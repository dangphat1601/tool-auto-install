$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("HomePage.feature");
formatter.feature({
  "line": 2,
  "name": "Check functions for Home page Fireapps.io",
  "description": "As a user\r\nI want to check all functions of Home page",
  "id": "check-functions-for-home-page-fireapps.io",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@HomePage"
    }
  ]
});
formatter.scenario({
  "line": 6,
  "name": "01 - Check the Header",
  "description": "",
  "id": "check-functions-for-home-page-fireapps.io;01---check-the-header",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "I access the website",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I access the \"Home\" from header",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "verify the Home page has been accessed",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I take the screenshot as \"Header1-Home.jpg\"",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 11,
      "value": "#    And I close the messenger pop up"
    }
  ],
  "line": 12,
  "name": "I access the \"SHOPIFY APPS\" from header",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "verify the Shopify Apps page has been accessed",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I take the screenshot as \"Header2-ShopifyApps.jpg\"",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I access the \"Blog\" from header",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "verify the Blog page has been accessed",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I take the screenshot as \"Header3-Blog.jpg\"",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I access the \"Affiliate\" from header",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "verify the Affiliate page has been accessed",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "I access the \"Get App Now\" from header",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "verify the FireApps app store has been accessed",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "I take the screenshot as \"Header5-GetAppNow.jpg\"",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "I quit the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "WebsiteSteps.i_access_the_website()"
});
formatter.result({
  "duration": 8567678981,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Home",
      "offset": 14
    }
  ],
  "location": "WebsiteSteps.i_access_the_something_from_header(String)"
});
formatter.result({
  "duration": 917212250,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_home_page_has_been_accessed()"
});
formatter.result({
  "duration": 117034812,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Header1-Home.jpg",
      "offset": 26
    }
  ],
  "location": "WebsiteSteps.i_take_the_screenshot_as_something(String)"
});
formatter.result({
  "duration": 597386207,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SHOPIFY APPS",
      "offset": 14
    }
  ],
  "location": "WebsiteSteps.i_access_the_something_from_header(String)"
});
formatter.result({
  "duration": 661818373,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_shopify_apps_page_has_been_accessed()"
});
formatter.result({
  "duration": 2010042406,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Header2-ShopifyApps.jpg",
      "offset": 26
    }
  ],
  "location": "WebsiteSteps.i_take_the_screenshot_as_something(String)"
});
formatter.result({
  "duration": 433014023,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Blog",
      "offset": 14
    }
  ],
  "location": "WebsiteSteps.i_access_the_something_from_header(String)"
});
formatter.result({
  "duration": 1061683549,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_blog_page_has_been_accessed()"
});
formatter.result({
  "duration": 2039903587,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Header3-Blog.jpg",
      "offset": 26
    }
  ],
  "location": "WebsiteSteps.i_take_the_screenshot_as_something(String)"
});
formatter.result({
  "duration": 512068664,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Affiliate",
      "offset": 14
    }
  ],
  "location": "WebsiteSteps.i_access_the_something_from_header(String)"
});
formatter.result({
  "duration": 138377130,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_affiliate_page_has_been_accessed()"
});
formatter.result({
  "duration": 5546702461,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Get App Now",
      "offset": 14
    }
  ],
  "location": "WebsiteSteps.i_access_the_something_from_header(String)"
});
formatter.result({
  "duration": 659084536,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_fireapps_app_store_has_been_accessed()"
});
formatter.result({
  "duration": 10621278,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Header5-GetAppNow.jpg",
      "offset": 26
    }
  ],
  "location": "WebsiteSteps.i_take_the_screenshot_as_something(String)"
});
formatter.result({
  "duration": 375738934,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_quit_the_browser()"
});
formatter.result({
  "duration": 840835612,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "02 - Check Apps list slide bar",
  "description": "",
  "id": "check-functions-for-home-page-fireapps.io;02---check-apps-list-slide-bar",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 26,
  "name": "I access the website",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "I click on Get App Now button",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "verify the Shopify Apps page has been accessed",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "I access the \"Home\" from header",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "I check the Ali Review app from the slider",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "I take the screenshot as \"HomePage1-AliReviewSlide.jpg\"",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "I click to Get App button of \"Ali Reviews\" app",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "verify the Ali Reviews install page appears",
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "I check the Ali Hunter app from the slider",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "I take the screenshot as \"HomePage2-AliHunterSlide.jpg\"",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "I click to Get App button of \"Ali Hunter\" app",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "verify the Ali Hunter install page appears",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "I check the Ali Orders app from the slider",
  "keyword": "And "
});
formatter.step({
  "line": 39,
  "name": "I take the screenshot as \"HomePage3-AliOrdersSlide.jpg\"",
  "keyword": "And "
});
formatter.step({
  "line": 40,
  "name": "I click to Get App button of \"Ali Orders\" app",
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "verify the Ali Orders install page appears",
  "keyword": "And "
});
formatter.step({
  "line": 42,
  "name": "I check the Sales Box app from the slider",
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "I take the screenshot as \"HomePage4-SalesBoxSlide.jpg\"",
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "I click to Get App button of \"Sales Box\" app",
  "keyword": "And "
});
formatter.step({
  "line": 45,
  "name": "verify the Sales Box install page appears",
  "keyword": "Then "
});
formatter.step({
  "line": 46,
  "name": "I quit the browser",
  "keyword": "And "
});
formatter.match({
  "location": "WebsiteSteps.i_access_the_website()"
});
formatter.result({
  "duration": 5739524364,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_click_on_get_app_now_button()"
});
formatter.result({
  "duration": 813731669,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_shopify_apps_page_has_been_accessed()"
});
formatter.result({
  "duration": 2006725591,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Home",
      "offset": 14
    }
  ],
  "location": "WebsiteSteps.i_access_the_something_from_header(String)"
});
formatter.result({
  "duration": 654557838,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_check_the_ali_review_app_from_the_slider()"
});
formatter.result({
  "duration": 1184600687,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "HomePage1-AliReviewSlide.jpg",
      "offset": 26
    }
  ],
  "location": "WebsiteSteps.i_take_the_screenshot_as_something(String)"
});
formatter.result({
  "duration": 449385431,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ali Reviews",
      "offset": 30
    }
  ],
  "location": "WebsiteSteps.i_click_to_get_app_button_of_something_app(String)"
});
formatter.result({
  "duration": 771675991,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_ali_reviews_install_page_appears()"
});
formatter.result({
  "duration": 2439512582,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_check_the_ali_hunter_app_from_the_slider()"
});
formatter.result({
  "duration": 1249345689,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "HomePage2-AliHunterSlide.jpg",
      "offset": 26
    }
  ],
  "location": "WebsiteSteps.i_take_the_screenshot_as_something(String)"
});
formatter.result({
  "duration": 442087537,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ali Hunter",
      "offset": 30
    }
  ],
  "location": "WebsiteSteps.i_click_to_get_app_button_of_something_app(String)"
});
formatter.result({
  "duration": 116867309,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_ali_hunter_install_page_appears()"
});
formatter.result({
  "duration": 3242282218,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_check_the_ali_orders_app_from_the_slider()"
});
formatter.result({
  "duration": 2152116106,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "HomePage3-AliOrdersSlide.jpg",
      "offset": 26
    }
  ],
  "location": "WebsiteSteps.i_take_the_screenshot_as_something(String)"
});
formatter.result({
  "duration": 423189208,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ali Orders",
      "offset": 30
    }
  ],
  "location": "WebsiteSteps.i_click_to_get_app_button_of_something_app(String)"
});
formatter.result({
  "duration": 133882044,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_ali_orders_install_page_appears()"
});
formatter.result({
  "duration": 5648417688,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_check_the_sales_box_app_from_the_slider()"
});
formatter.result({
  "duration": 1202889352,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "HomePage4-SalesBoxSlide.jpg",
      "offset": 26
    }
  ],
  "location": "WebsiteSteps.i_take_the_screenshot_as_something(String)"
});
formatter.result({
  "duration": 456818806,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sales Box",
      "offset": 30
    }
  ],
  "location": "WebsiteSteps.i_click_to_get_app_button_of_something_app(String)"
});
formatter.result({
  "duration": 168584403,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_sales_box_install_page_appears()"
});
formatter.result({
  "duration": 1448774536,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_quit_the_browser()"
});
formatter.result({
  "duration": 973974565,
  "status": "passed"
});
formatter.scenario({
  "line": 48,
  "name": "03 - Check testimonial slide",
  "description": "",
  "id": "check-functions-for-home-page-fireapps.io;03---check-testimonial-slide",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 49,
  "name": "I access the website",
  "keyword": "Given "
});
formatter.step({
  "line": 50,
  "name": "I wait for testimonial slide \"1\" display and take the screenshot",
  "keyword": "When "
});
formatter.step({
  "line": 51,
  "name": "I wait for testimonial slide \"2\" display and take the screenshot",
  "keyword": "And "
});
formatter.step({
  "line": 52,
  "name": "I wait for testimonial slide \"3\" display and take the screenshot",
  "keyword": "And "
});
formatter.step({
  "line": 53,
  "name": "I wait for testimonial slide \"4\" display and take the screenshot",
  "keyword": "And "
});
formatter.step({
  "line": 54,
  "name": "I wait for testimonial slide \"5\" display and take the screenshot",
  "keyword": "And "
});
formatter.step({
  "line": 55,
  "name": "I wait for testimonial slide \"6\" display and take the screenshot",
  "keyword": "And "
});
formatter.step({
  "line": 56,
  "name": "I wait for testimonial slide \"7\" display and take the screenshot",
  "keyword": "And "
});
formatter.step({
  "line": 57,
  "name": "I wait for testimonial slide \"8\" display and take the screenshot",
  "keyword": "Then "
});
formatter.step({
  "line": 58,
  "name": "I quit the browser",
  "keyword": "And "
});
formatter.match({
  "location": "WebsiteSteps.i_access_the_website()"
});
formatter.result({
  "duration": 5750355021,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 30
    }
  ],
  "location": "WebsiteSteps.i_wait_for_testimonial_slide_something_display_and_take_the_screenshot(String)"
});
formatter.result({
  "duration": 1667007284,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 30
    }
  ],
  "location": "WebsiteSteps.i_wait_for_testimonial_slide_something_display_and_take_the_screenshot(String)"
});
formatter.result({
  "duration": 3339179258,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 30
    }
  ],
  "location": "WebsiteSteps.i_wait_for_testimonial_slide_something_display_and_take_the_screenshot(String)"
});
formatter.result({
  "duration": 4795969325,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4",
      "offset": 30
    }
  ],
  "location": "WebsiteSteps.i_wait_for_testimonial_slide_something_display_and_take_the_screenshot(String)"
});
formatter.result({
  "duration": 4750273323,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 30
    }
  ],
  "location": "WebsiteSteps.i_wait_for_testimonial_slide_something_display_and_take_the_screenshot(String)"
});
formatter.result({
  "duration": 4847205259,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "6",
      "offset": 30
    }
  ],
  "location": "WebsiteSteps.i_wait_for_testimonial_slide_something_display_and_take_the_screenshot(String)"
});
formatter.result({
  "duration": 4792370875,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "7",
      "offset": 30
    }
  ],
  "location": "WebsiteSteps.i_wait_for_testimonial_slide_something_display_and_take_the_screenshot(String)"
});
formatter.result({
  "duration": 4785683875,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "8",
      "offset": 30
    }
  ],
  "location": "WebsiteSteps.i_wait_for_testimonial_slide_something_display_and_take_the_screenshot(String)"
});
formatter.result({
  "duration": 4858733436,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_quit_the_browser()"
});
formatter.result({
  "duration": 781522155,
  "status": "passed"
});
formatter.scenario({
  "line": 60,
  "name": "04 - Check blog posts in Home page",
  "description": "",
  "id": "check-functions-for-home-page-fireapps.io;04---check-blog-posts-in-home-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 61,
  "name": "I access the website",
  "keyword": "Given "
});
formatter.step({
  "line": 62,
  "name": "I check the 1st blog post at Home page work well",
  "keyword": "When "
});
formatter.step({
  "line": 63,
  "name": "I return to Home page",
  "keyword": "And "
});
formatter.step({
  "line": 64,
  "name": "I check the 2nd blog post at Home page work well",
  "keyword": "And "
});
formatter.step({
  "line": 65,
  "name": "I return to Home page",
  "keyword": "And "
});
formatter.step({
  "line": 66,
  "name": "I check the 3rd blog post at Home page work well",
  "keyword": "And "
});
formatter.step({
  "line": 67,
  "name": "I back to Home page",
  "keyword": "And "
});
formatter.step({
  "line": 68,
  "name": "I click to View all blogs link",
  "keyword": "And "
});
formatter.step({
  "line": 69,
  "name": "verify the Blog page has been accessed",
  "keyword": "Then "
});
formatter.step({
  "line": 70,
  "name": "I quit the browser",
  "keyword": "And "
});
formatter.match({
  "location": "WebsiteSteps.i_access_the_website()"
});
formatter.result({
  "duration": 5702036439,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_check_the_1st_blog_post_at_home_page_work_well()"
});
formatter.result({
  "duration": 1372784633,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_return_to_home_page()"
});
formatter.result({
  "duration": 616525117,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_check_the_2nd_blog_post_at_home_page_work_well()"
});
formatter.result({
  "duration": 956091932,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_return_to_home_page()"
});
formatter.result({
  "duration": 712071455,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_check_the_3rd_blog_post_at_home_page_work_well()"
});
formatter.result({
  "duration": 819664903,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_back_to_home_page()"
});
formatter.result({
  "duration": 396837798,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_click_to_view_all_blogs_link()"
});
formatter.result({
  "duration": 909194255,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_blog_page_has_been_accessed()"
});
formatter.result({
  "duration": 2042499069,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_quit_the_browser()"
});
formatter.result({
  "duration": 1200424835,
  "status": "passed"
});
formatter.scenario({
  "line": 72,
  "name": "05 - Check the footer",
  "description": "",
  "id": "check-functions-for-home-page-fireapps.io;05---check-the-footer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 73,
  "name": "I access the website",
  "keyword": "Given "
});
formatter.step({
  "line": 74,
  "name": "I click to \"Shopify Apps\" from the footer",
  "keyword": "When "
});
formatter.step({
  "line": 75,
  "name": "verify the Shopify Apps page has been accessed",
  "keyword": "And "
});
formatter.step({
  "line": 76,
  "name": "I click to \"New\" from the footer",
  "keyword": "And "
});
formatter.step({
  "line": 77,
  "name": "verify the What\u0027s New page has been accessed",
  "keyword": "And "
});
formatter.step({
  "line": 78,
  "name": "I take the screenshot as \"Footer1-WhatsNew.jpg\"",
  "keyword": "And "
});
formatter.step({
  "line": 79,
  "name": "I back to Home page",
  "keyword": "And "
});
formatter.step({
  "line": 80,
  "name": "I click to \"Contact Us\" from the footer",
  "keyword": "And "
});
formatter.step({
  "line": 81,
  "name": "verify the Contact Us page has been accessed",
  "keyword": "And "
});
formatter.step({
  "line": 82,
  "name": "I take the screenshot as \"Footer2-ContactUs.jpg\"",
  "keyword": "And "
});
formatter.step({
  "line": 83,
  "name": "I back to Home page",
  "keyword": "And "
});
formatter.step({
  "line": 84,
  "name": "I click to \"About Us\" from the footer",
  "keyword": "And "
});
formatter.step({
  "line": 85,
  "name": "verify the About Us page has been accessed",
  "keyword": "And "
});
formatter.step({
  "line": 86,
  "name": "I take the screenshot as \"Footer3-AboutUs.jpg\"",
  "keyword": "And "
});
formatter.step({
  "line": 87,
  "name": "I back to Home page",
  "keyword": "And "
});
formatter.step({
  "line": 88,
  "name": "I click to \"Help Center\" from the footer",
  "keyword": "And "
});
formatter.step({
  "line": 89,
  "name": "verify the Help Center page has been accessed",
  "keyword": "And "
});
formatter.step({
  "line": 90,
  "name": "I take the screenshot as \"Footer4-HelpCenter.jpg\"",
  "keyword": "And "
});
formatter.step({
  "line": 91,
  "name": "I back to Home page",
  "keyword": "And "
});
formatter.step({
  "line": 92,
  "name": "I click to \"Privacy Policy\" from the footer",
  "keyword": "And "
});
formatter.step({
  "line": 93,
  "name": "verify the Privacy Policy page has been accessed",
  "keyword": "And "
});
formatter.step({
  "line": 94,
  "name": "I take the screenshot as \"Footer5-PrivacyPolicy.jpg\"",
  "keyword": "And "
});
formatter.step({
  "line": 95,
  "name": "I back to Home page",
  "keyword": "And "
});
formatter.step({
  "line": 96,
  "name": "I scroll to the bottom of page",
  "keyword": "And "
});
formatter.step({
  "line": 97,
  "name": "I click to \"Terms of Service\" from the footer",
  "keyword": "And "
});
formatter.step({
  "line": 98,
  "name": "verify the Term of Service page has been accessed",
  "keyword": "And "
});
formatter.step({
  "line": 99,
  "name": "I take the screenshot as \"Footer6-TermsOfService.jpg\"",
  "keyword": "And "
});
formatter.step({
  "line": 100,
  "name": "I click to \"Facebook\" social icon in the footer",
  "keyword": "And "
});
formatter.step({
  "line": 101,
  "name": "verify the Facebook page has been accessed",
  "keyword": "And "
});
formatter.step({
  "line": 102,
  "name": "I back to Home page",
  "keyword": "And "
});
formatter.step({
  "line": 103,
  "name": "I click to \"Instagram\" social icon in the footer",
  "keyword": "And "
});
formatter.step({
  "line": 104,
  "name": "verify the Instagram page has been accessed",
  "keyword": "And "
});
formatter.step({
  "line": 105,
  "name": "I back to Home page",
  "keyword": "And "
});
formatter.step({
  "line": 106,
  "name": "I click to \"Twitter\" social icon in the footer",
  "keyword": "And "
});
formatter.step({
  "line": 107,
  "name": "verify the Twitter page has been accessed",
  "keyword": "And "
});
formatter.step({
  "line": 108,
  "name": "I back to Home page",
  "keyword": "And "
});
formatter.step({
  "line": 109,
  "name": "I click to \"Youtube\" social icon in the footer",
  "keyword": "And "
});
formatter.step({
  "line": 110,
  "name": "verify the Youtube page has been accessed",
  "keyword": "And "
});
formatter.step({
  "line": 111,
  "name": "I quit the browser",
  "keyword": "And "
});
formatter.match({
  "location": "WebsiteSteps.i_access_the_website()"
});
formatter.result({
  "duration": 5438641810,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Shopify Apps",
      "offset": 12
    }
  ],
  "location": "WebsiteSteps.i_click_to_something_from_the_footer(String)"
});
formatter.result({
  "duration": 800529278,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_shopify_apps_page_has_been_accessed()"
});
formatter.result({
  "duration": 2005263220,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "New",
      "offset": 12
    }
  ],
  "location": "WebsiteSteps.i_click_to_something_from_the_footer(String)"
});
formatter.result({
  "duration": 2238231345,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_whats_new_page_has_been_accessed()"
});
formatter.result({
  "duration": 48028735,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Footer1-WhatsNew.jpg",
      "offset": 26
    }
  ],
  "location": "WebsiteSteps.i_take_the_screenshot_as_something(String)"
});
formatter.result({
  "duration": 456195185,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_back_to_home_page()"
});
formatter.result({
  "duration": 547669300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Contact Us",
      "offset": 12
    }
  ],
  "location": "WebsiteSteps.i_click_to_something_from_the_footer(String)"
});
formatter.result({
  "duration": 1280362153,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_contact_us_page_has_been_accessed()"
});
formatter.result({
  "duration": 163982575,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Footer2-ContactUs.jpg",
      "offset": 26
    }
  ],
  "location": "WebsiteSteps.i_take_the_screenshot_as_something(String)"
});
formatter.result({
  "duration": 747675787,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_back_to_home_page()"
});
formatter.result({
  "duration": 549456825,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "About Us",
      "offset": 12
    }
  ],
  "location": "WebsiteSteps.i_click_to_something_from_the_footer(String)"
});
formatter.result({
  "duration": 726294467,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_about_us_page_has_been_accessed()"
});
formatter.result({
  "duration": 1030485214,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Footer3-AboutUs.jpg",
      "offset": 26
    }
  ],
  "location": "WebsiteSteps.i_take_the_screenshot_as_something(String)"
});
formatter.result({
  "duration": 363839623,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_back_to_home_page()"
});
formatter.result({
  "duration": 634145000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Help Center",
      "offset": 12
    }
  ],
  "location": "WebsiteSteps.i_click_to_something_from_the_footer(String)"
});
formatter.result({
  "duration": 450864224,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_help_center_page_has_been_accessed()"
});
formatter.result({
  "duration": 4037947327,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Footer4-HelpCenter.jpg",
      "offset": 26
    }
  ],
  "location": "WebsiteSteps.i_take_the_screenshot_as_something(String)"
});
formatter.result({
  "duration": 438840104,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_back_to_home_page()"
});
formatter.result({
  "duration": 854985958,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Privacy Policy",
      "offset": 12
    }
  ],
  "location": "WebsiteSteps.i_click_to_something_from_the_footer(String)"
});
formatter.result({
  "duration": 639005062,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_privacy_policy_page_has_been_accessed()"
});
formatter.result({
  "duration": 30263108,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Footer5-PrivacyPolicy.jpg",
      "offset": 26
    }
  ],
  "location": "WebsiteSteps.i_take_the_screenshot_as_something(String)"
});
formatter.result({
  "duration": 370651838,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_back_to_home_page()"
});
formatter.result({
  "duration": 272265332,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_scroll_to_the_bottom_of_page()"
});
formatter.result({
  "duration": 129606601,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Terms of Service",
      "offset": 12
    }
  ],
  "location": "WebsiteSteps.i_click_to_something_from_the_footer(String)"
});
formatter.result({
  "duration": 11758434188,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_term_of_service_page_has_been_accessed()"
});
formatter.result({
  "duration": 38492124,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Footer6-TermsOfService.jpg",
      "offset": 26
    }
  ],
  "location": "WebsiteSteps.i_take_the_screenshot_as_something(String)"
});
formatter.result({
  "duration": 389167947,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Facebook",
      "offset": 12
    }
  ],
  "location": "WebsiteSteps.i_click_to_something_social_icon_in_the_footer(String)"
});
formatter.result({
  "duration": 162696740,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_facebook_page_has_been_accessed()"
});
formatter.result({
  "duration": 2720178539,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_back_to_home_page()"
});
formatter.result({
  "duration": 962217302,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Instagram",
      "offset": 12
    }
  ],
  "location": "WebsiteSteps.i_click_to_something_social_icon_in_the_footer(String)"
});
formatter.result({
  "duration": 288461025,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_instagram_page_has_been_accessed()"
});
formatter.result({
  "duration": 2320703383,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_back_to_home_page()"
});
formatter.result({
  "duration": 1105479538,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Twitter",
      "offset": 12
    }
  ],
  "location": "WebsiteSteps.i_click_to_something_social_icon_in_the_footer(String)"
});
formatter.result({
  "duration": 1257309903,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_twitter_page_has_been_accessed()"
});
formatter.result({
  "duration": 2790459366,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_back_to_home_page()"
});
formatter.result({
  "duration": 1296240492,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Youtube",
      "offset": 12
    }
  ],
  "location": "WebsiteSteps.i_click_to_something_social_icon_in_the_footer(String)"
});
formatter.result({
  "duration": 323314876,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_youtube_page_has_been_accessed()"
});
formatter.result({
  "duration": 4442839249,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_quit_the_browser()"
});
formatter.result({
  "duration": 1029170230,
  "status": "passed"
});
formatter.uri("WhatsNewPage.feature");
formatter.feature({
  "line": 2,
  "name": "Check functions for What\u0027s New page on Fireapps.io",
  "description": "As a user\r\nI want to check all functions of What\u0027s New page",
  "id": "check-functions-for-what\u0027s-new-page-on-fireapps.io",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@WhatsNewPage"
    }
  ]
});
formatter.scenario({
  "line": 6,
  "name": "01 - Check lazy load",
  "description": "",
  "id": "check-functions-for-what\u0027s-new-page-on-fireapps.io;01---check-lazy-load",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "I access the website",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I click to \"New\" from the footer",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "verify the What\u0027s New page has been accessed",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "verify the loading wheel is displayed if there are more than 4 posts",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "verify the text label display after scroll to the end of page",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I quit the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "WebsiteSteps.i_access_the_website()"
});
formatter.result({
  "duration": 6137353635,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "New",
      "offset": 12
    }
  ],
  "location": "WebsiteSteps.i_click_to_something_from_the_footer(String)"
});
formatter.result({
  "duration": 2014996073,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_whats_new_page_has_been_accessed()"
});
formatter.result({
  "duration": 37500241,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_loading_wheel_is_displayed_if_there_are_more_than_4_posts()"
});
formatter.result({
  "duration": 123094905,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_text_label_display_after_scroll_to_the_end_of_page()"
});
formatter.result({
  "duration": 2052913020,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_quit_the_browser()"
});
formatter.result({
  "duration": 1207607366,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "02 - Check filter by apps checkboxes",
  "description": "",
  "id": "check-functions-for-what\u0027s-new-page-on-fireapps.io;02---check-filter-by-apps-checkboxes",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "I access the website",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "I click to \"New\" from the footer",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "verify the What\u0027s New page has been accessed",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I click on the \"Ali Reviews\" checkbox",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "verify that only the posts of \"Ali Reviews\" displayed",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "I click on back to all changes button",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "I click on the \"Ali Hunter\" checkbox",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "verify that only the posts of \"Ali Hunter\" displayed",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "I click on back to all changes button",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "I click on the \"Ali Orders\" checkbox",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "verify that only the posts of \"Ali Orders\" displayed",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "I click on back to all changes button",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "I click on the \"Sales Box\" checkbox",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "verify that only the posts of \"Sales Box\" displayed",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "I click on back to all changes button",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "I quit the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "WebsiteSteps.i_access_the_website()"
});
formatter.result({
  "duration": 4788510086,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "New",
      "offset": 12
    }
  ],
  "location": "WebsiteSteps.i_click_to_something_from_the_footer(String)"
});
formatter.result({
  "duration": 13248142785,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_whats_new_page_has_been_accessed()"
});
formatter.result({
  "duration": 38102925,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ali Reviews",
      "offset": 16
    }
  ],
  "location": "WebsiteSteps.i_click_on_the_something_checkbox(String)"
});
formatter.result({
  "duration": 1364391808,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ali Reviews",
      "offset": 31
    }
  ],
  "location": "WebsiteSteps.verify_that_only_the_posts_of_something_displayed(String)"
});
formatter.result({
  "duration": 9139292241,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_click_on_back_to_all_changes_button()"
});
formatter.result({
  "duration": 591621708,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ali Hunter",
      "offset": 16
    }
  ],
  "location": "WebsiteSteps.i_click_on_the_something_checkbox(String)"
});
formatter.result({
  "duration": 1354396205,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ali Hunter",
      "offset": 31
    }
  ],
  "location": "WebsiteSteps.verify_that_only_the_posts_of_something_displayed(String)"
});
formatter.result({
  "duration": 9174041402,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_click_on_back_to_all_changes_button()"
});
formatter.result({
  "duration": 672892074,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ali Orders",
      "offset": 16
    }
  ],
  "location": "WebsiteSteps.i_click_on_the_something_checkbox(String)"
});
formatter.result({
  "duration": 1438852831,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ali Orders",
      "offset": 31
    }
  ],
  "location": "WebsiteSteps.verify_that_only_the_posts_of_something_displayed(String)"
});
formatter.result({
  "duration": 9125122600,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_click_on_back_to_all_changes_button()"
});
formatter.result({
  "duration": 605448542,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sales Box",
      "offset": 16
    }
  ],
  "location": "WebsiteSteps.i_click_on_the_something_checkbox(String)"
});
formatter.result({
  "duration": 1456641449,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sales Box",
      "offset": 31
    }
  ],
  "location": "WebsiteSteps.verify_that_only_the_posts_of_something_displayed(String)"
});
formatter.result({
  "duration": 9126362864,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_click_on_back_to_all_changes_button()"
});
formatter.result({
  "duration": 649478543,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_quit_the_browser()"
});
formatter.result({
  "duration": 763804150,
  "status": "passed"
});
formatter.scenario({
  "line": 32,
  "name": "03 - Check filter by tags",
  "description": "",
  "id": "check-functions-for-what\u0027s-new-page-on-fireapps.io;03---check-filter-by-tags",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 33,
  "name": "I access the website",
  "keyword": "Given "
});
formatter.step({
  "line": 34,
  "name": "I click to \"New\" from the footer",
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "verify the What\u0027s New page has been accessed",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "I select the \"Ali Reviews\" tag",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "verify that only the posts of \"Ali Reviews\" displayed",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "I click on back to all changes button",
  "keyword": "And "
});
formatter.step({
  "line": 39,
  "name": "I select the \"Ali Hunter\" tag",
  "keyword": "And "
});
formatter.step({
  "line": 40,
  "name": "verify that only the posts of \"Ali Hunter\" displayed",
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "I click on back to all changes button",
  "keyword": "And "
});
formatter.step({
  "line": 42,
  "name": "I scroll to the bottom of page",
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "I select the \"Ali Orders\" tag",
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "verify that only the posts of \"Ali Orders\" displayed",
  "keyword": "And "
});
formatter.step({
  "line": 45,
  "name": "I click on back to all changes button",
  "keyword": "And "
});
formatter.step({
  "line": 46,
  "name": "I scroll to the bottom of page",
  "keyword": "And "
});
formatter.step({
  "line": 47,
  "name": "I select the \"Sales Box\" tag",
  "keyword": "And "
});
formatter.step({
  "line": 48,
  "name": "verify that only the posts of \"Sales Box\" displayed",
  "keyword": "And "
});
formatter.step({
  "line": 49,
  "name": "I quit the browser",
  "keyword": "And "
});
formatter.match({
  "location": "WebsiteSteps.i_access_the_website()"
});
formatter.result({
  "duration": 5438803976,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "New",
      "offset": 12
    }
  ],
  "location": "WebsiteSteps.i_click_to_something_from_the_footer(String)"
});
formatter.result({
  "duration": 1663922019,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_whats_new_page_has_been_accessed()"
});
formatter.result({
  "duration": 35247156,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ali Reviews",
      "offset": 14
    }
  ],
  "location": "WebsiteSteps.i_select_the_something_tag(String)"
});
formatter.result({
  "duration": 412223891,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ali Reviews",
      "offset": 31
    }
  ],
  "location": "WebsiteSteps.verify_that_only_the_posts_of_something_displayed(String)"
});
formatter.result({
  "duration": 9065850197,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_click_on_back_to_all_changes_button()"
});
formatter.result({
  "duration": 678984190,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ali Hunter",
      "offset": 14
    }
  ],
  "location": "WebsiteSteps.i_select_the_something_tag(String)"
});
formatter.result({
  "duration": 336318973,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ali Hunter",
      "offset": 31
    }
  ],
  "location": "WebsiteSteps.verify_that_only_the_posts_of_something_displayed(String)"
});
formatter.result({
  "duration": 9180748929,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_click_on_back_to_all_changes_button()"
});
formatter.result({
  "duration": 646530811,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_scroll_to_the_bottom_of_page()"
});
formatter.result({
  "duration": 23331832,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ali Orders",
      "offset": 14
    }
  ],
  "location": "WebsiteSteps.i_select_the_something_tag(String)"
});
formatter.result({
  "duration": 1414282788,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ali Orders",
      "offset": 31
    }
  ],
  "location": "WebsiteSteps.verify_that_only_the_posts_of_something_displayed(String)"
});
formatter.result({
  "duration": 9119059632,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_click_on_back_to_all_changes_button()"
});
formatter.result({
  "duration": 581078434,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_scroll_to_the_bottom_of_page()"
});
formatter.result({
  "duration": 20693242,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sales Box",
      "offset": 14
    }
  ],
  "location": "WebsiteSteps.i_select_the_something_tag(String)"
});
formatter.result({
  "duration": 1653896446,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sales Box",
      "offset": 31
    }
  ],
  "location": "WebsiteSteps.verify_that_only_the_posts_of_something_displayed(String)"
});
formatter.result({
  "duration": 9149632293,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_quit_the_browser()"
});
formatter.result({
  "duration": 761643028,
  "status": "passed"
});
formatter.scenario({
  "line": 51,
  "name": "04 - Check Search function",
  "description": "",
  "id": "check-functions-for-what\u0027s-new-page-on-fireapps.io;04---check-search-function",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 52,
  "name": "I access the website",
  "keyword": "Given "
});
formatter.step({
  "line": 53,
  "name": "I click to \"New\" from the footer",
  "keyword": "When "
});
formatter.step({
  "line": 54,
  "name": "verify the What\u0027s New page has been accessed",
  "keyword": "And "
});
formatter.step({
  "line": 55,
  "name": "I input the \"review\" keyword to the search text box",
  "keyword": "And "
});
formatter.step({
  "line": 56,
  "name": "I click to search button",
  "keyword": "And "
});
formatter.step({
  "line": 57,
  "name": "verify the result contains the \"review\" keyword",
  "keyword": "Then "
});
formatter.step({
  "line": 58,
  "name": "I click on back to all changes button",
  "keyword": "And "
});
formatter.step({
  "line": 59,
  "name": "I input the \"!@#\" keyword to the search text box",
  "keyword": "And "
});
formatter.step({
  "line": 60,
  "name": "I click to search button",
  "keyword": "And "
});
formatter.step({
  "line": 61,
  "name": "verify there are no result display",
  "keyword": "Then "
});
formatter.match({
  "location": "WebsiteSteps.i_access_the_website()"
});
formatter.result({
  "duration": 5383459282,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "New",
      "offset": 12
    }
  ],
  "location": "WebsiteSteps.i_click_to_something_from_the_footer(String)"
});
formatter.result({
  "duration": 1804181510,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_the_whats_new_page_has_been_accessed()"
});
formatter.result({
  "duration": 40637235,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "review",
      "offset": 13
    }
  ],
  "location": "WebsiteSteps.i_input_the_something_keyword_to_the_search_text_box(String)"
});
formatter.result({
  "duration": 160469930,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_click_to_search_button()"
});
formatter.result({
  "duration": 472558380,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "review",
      "offset": 32
    }
  ],
  "location": "WebsiteSteps.verify_the_result_contains_the_something_keyword(String)"
});
formatter.result({
  "duration": 38912525,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_click_on_back_to_all_changes_button()"
});
formatter.result({
  "duration": 501739696,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "!@#",
      "offset": 13
    }
  ],
  "location": "WebsiteSteps.i_input_the_something_keyword_to_the_search_text_box(String)"
});
formatter.result({
  "duration": 146776934,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.i_click_to_search_button()"
});
formatter.result({
  "duration": 475983990,
  "status": "passed"
});
formatter.match({
  "location": "WebsiteSteps.verify_there_are_no_result_display()"
});
formatter.result({
  "duration": 31855211,
  "status": "passed"
});
});