package Money_task;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MoneyMain {
    public WebDriver driver;
    int scroll_number;

    @Given("On money site")
    public void logging_in() throws InterruptedException {
//        driver configuration
        System.setProperty("webdriver.gecko.driver", "src/main/resources/Drivers/geckodriver");
//        initialising new browser window
        driver = new FirefoxDriver();
//        maximizing window size
        driver.manage().window().maximize();
        driver.get("https://www.money.pl/");
        Thread.sleep(3000);
        WebElement agree = driver.findElement(By.xpath("//*[text()='AKCEPTUJĘ I PRZECHODZĘ DO SERWISU']"));
        agree.click();
        Thread.sleep(5000);
        WebElement cookies = driver.findElement(By.xpath("//*[@d='M55.9 47.5L94.3 9.1c0.8-0.8 0.8-2.2 0-3L88.8 0.6C88.4 0.2 87.9 0 87.3 0c-0.6 0-1.1 0.2-1.5 0.6L47.5 39 9.1 0.6c-0.8-0.8-2.2-0.8-3 0L0.6 6.1c-0.8 0.8-0.8 2.2 0 3l38.4 38.4L0.6 85.8c-0.8 0.8-0.8 2.2 0 3l5.5 5.5c0.4 0.4 0.9 0.6 1.5 0.6s1.1-0.2 1.5-0.6l38.4-38.4 38.4 38.4c0.4 0.4 0.9 0.6 1.5 0.6s1.1-0.2 1.5-0.6l5.5-5.5c0.8-0.8 0.8-2.2 0-3L55.9 47.5z']"));
        cookies.click();
    }
    @When("user scrolls \"([^\"]*)\" times$")
    public void scrolling(int clicks) throws InterruptedException {
        Thread.sleep(1000);
        for (int y=0; y<clicks; y++){
            Thread.sleep(1500);
            WebElement next = driver.findElement(By.xpath("//*[@class='sc-143eo0d-0 sc-1j5p3rt-0 jGLyum']"));
            next.click();
            System.out.println(y);
            scroll_number = y;
        }
    }
    @Then("site was scrolled \"([^\"]*)\" times$")
//    checking scroll number
    public void site_scrolled(int final_clicks){
            if (scroll_number != final_clicks - 1) {
                throw new ArithmeticException("numbers aren't right");
            }else{
                System.out.println("passed");
            }
        }
    }
