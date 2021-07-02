@WhatsNewPage
Feature: Check functions for What's New page on Fireapps.io
  As a user
  I want to check all functions of What's New page

  Scenario: 01 - Check lazy load
    Given I access the website
    When I click to "New" from the footer
    And verify the What's New page has been accessed
    And verify the loading wheel is displayed if there are more than 4 posts
    And verify the text label display after scroll to the end of page
    Then I quit the browser

  Scenario: 02 - Check filter by apps checkboxes
    Given I access the website
    When I click to "New" from the footer
    And verify the What's New page has been accessed
    And I click on the "Ali Reviews" checkbox
    And verify that only the posts of "Ali Reviews" displayed
    And I click on back to all changes button
    And I click on the "Ali Hunter" checkbox
    And verify that only the posts of "Ali Hunter" displayed
    And I click on back to all changes button
    And I click on the "Ali Orders" checkbox
    And verify that only the posts of "Ali Orders" displayed
    And I click on back to all changes button
    And I click on the "Sales Box" checkbox
    And verify that only the posts of "Sales Box" displayed
    And I click on back to all changes button
    Then I quit the browser

  Scenario: 03 - Check filter by tags
    Given I access the website
    When I click to "New" from the footer
    And verify the What's New page has been accessed
    And I select the "Ali Reviews" tag
    And verify that only the posts of "Ali Reviews" displayed
    And I click on back to all changes button
    And I select the "Ali Hunter" tag
    And verify that only the posts of "Ali Hunter" displayed
    And I click on back to all changes button
    And I scroll to the bottom of page
    And I select the "Ali Orders" tag
    And verify that only the posts of "Ali Orders" displayed
    And I click on back to all changes button
    And I scroll to the bottom of page
    And I select the "Sales Box" tag
    And verify that only the posts of "Sales Box" displayed
    And I quit the browser

  Scenario: 04 - Check Search function
    Given I access the website
    When I click to "New" from the footer
    And verify the What's New page has been accessed
    And I input the "review" keyword to the search text box
    And I click to search button
    Then verify the result contains the "review" keyword
    And I click on back to all changes button
    And I input the "!@#" keyword to the search text box
    And I click to search button
    Then verify there are no result display



