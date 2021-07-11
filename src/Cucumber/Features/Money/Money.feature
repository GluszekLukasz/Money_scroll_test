Feature: Money scrolling
  Scenario: testing scrolling features on money.pl
    Given On money site
    When user scrolls "3" times
    Then site was scrolled "3" times