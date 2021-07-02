@HomePage
Feature: Check functions for Home page Fireapps.io
  As a user
  I want to check all functions of Home page

  Scenario: 01 - Check the Header
    Given I access the website
    When I access the "Home" from header
    And verify the Home page has been accessed
    And I take the screenshot as "Header1-Home.jpg"
#    And I close the messenger pop up
    And I access the "SHOPIFY APPS" from header
    And verify the Shopify Apps page has been accessed
    And I take the screenshot as "Header2-ShopifyApps.jpg"
    And I access the "Blog" from header
    And verify the Blog page has been accessed
    And I take the screenshot as "Header3-Blog.jpg"
    And I access the "Affiliate" from header
    And verify the Affiliate page has been accessed
    And I access the "Get App Now" from header
    And verify the FireApps app store has been accessed
    And I take the screenshot as "Header5-GetAppNow.jpg"
    Then I quit the browser

  Scenario: 02 - Check Apps list slide bar
    Given I access the website
    When I click on Get App Now button
    And verify the Shopify Apps page has been accessed
    And I access the "Home" from header
    And I check the Ali Review app from the slider
    And I take the screenshot as "HomePage1-AliReviewSlide.jpg"
    And I click to Get App button of "Ali Reviews" app
    And verify the Ali Reviews install page appears
    And I check the Ali Hunter app from the slider
    And I take the screenshot as "HomePage2-AliHunterSlide.jpg"
    And I click to Get App button of "Ali Hunter" app
    And verify the Ali Hunter install page appears
    And I check the Ali Orders app from the slider
    And I take the screenshot as "HomePage3-AliOrdersSlide.jpg"
    And I click to Get App button of "Ali Orders" app
    And verify the Ali Orders install page appears
    And I check the Sales Box app from the slider
    And I take the screenshot as "HomePage4-SalesBoxSlide.jpg"
    And I click to Get App button of "Sales Box" app
    Then verify the Sales Box install page appears
    And I quit the browser

  Scenario: 03 - Check testimonial slide
    Given I access the website
    When I wait for testimonial slide "1" display and take the screenshot
    And I wait for testimonial slide "2" display and take the screenshot
    And I wait for testimonial slide "3" display and take the screenshot
    And I wait for testimonial slide "4" display and take the screenshot
    And I wait for testimonial slide "5" display and take the screenshot
    And I wait for testimonial slide "6" display and take the screenshot
    And I wait for testimonial slide "7" display and take the screenshot
    Then I wait for testimonial slide "8" display and take the screenshot
    And I quit the browser

  Scenario: 04 - Check blog posts in Home page
    Given I access the website
    When I check the 1st blog post at Home page work well
    And I return to Home page
    And I check the 2nd blog post at Home page work well
    And I return to Home page
    And I check the 3rd blog post at Home page work well
    And I back to Home page
    And I click to View all blogs link
    Then verify the Blog page has been accessed
    And I quit the browser

  Scenario: 05 - Check the footer
    Given I access the website
    When I click to "Shopify Apps" from the footer
    And verify the Shopify Apps page has been accessed
    And I click to "New" from the footer
    And verify the What's New page has been accessed
    And I take the screenshot as "Footer1-WhatsNew.jpg"
    And I back to Home page
    And I click to "Contact Us" from the footer
    And verify the Contact Us page has been accessed
    And I take the screenshot as "Footer2-ContactUs.jpg"
    And I back to Home page
    And I click to "About Us" from the footer
    And verify the About Us page has been accessed
    And I take the screenshot as "Footer3-AboutUs.jpg"
    And I back to Home page
    And I click to "Help Center" from the footer
    And verify the Help Center page has been accessed
    And I take the screenshot as "Footer4-HelpCenter.jpg"
    And I back to Home page
    And I click to "Privacy Policy" from the footer
    And verify the Privacy Policy page has been accessed
    And I take the screenshot as "Footer5-PrivacyPolicy.jpg"
    And I back to Home page
    And I scroll to the bottom of page
    And I click to "Terms of Service" from the footer
    And verify the Term of Service page has been accessed
    And I take the screenshot as "Footer6-TermsOfService.jpg"
    And I click to "Facebook" social icon in the footer
    And verify the Facebook page has been accessed
    And I back to Home page
    And I click to "Instagram" social icon in the footer
    And verify the Instagram page has been accessed
    And I back to Home page
    And I click to "Twitter" social icon in the footer
    And verify the Twitter page has been accessed
    And I back to Home page
    And I click to "Youtube" social icon in the footer
    And verify the Youtube page has been accessed
    And I quit the browser




    