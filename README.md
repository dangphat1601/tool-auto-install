# tool-auto-install

Run test:

- run all

```mvn test```

- run a suite

```mvn -Dtest=createStoreAndInstallMessent test```

This project contains 3 main functions:
- Create the Shopify stores
- Install Origin App
- Uninstall Origin App
- Run test cases for website fireapps.io
- Spam reaction on What's New posts

<b>Infomation:</b>

Programming language: Java
Automation tool: Selenium
Library used: TestNG/Cucumber
Design pattern: Page Object Model

<b>I. Create the Shopify stores:</b>

This feature can be run by using "runCreateShopifyStore.xml" via the TestNG plugin.
You can config the parameter in the Constants.java in src/main/java/commons.
The parameter you can change:

EMAIL: this is the format of email, when running the methods, the tool will add the random number (4 digits) and @mail.com automatically.
STORE NAME: this is the format of store name, when running the methods, the tool will add the random number (4 digits) to store name.
PASSWORD: This password will be used for all the stores, should not change.
How to define the number of the store that I want to create?
To define the number of reapeat, access the file in the directory: src/test/java/createStore.java
Check the @Test annotation. There is a "invocationCount" parameter beside the @Test annotation.
Change the number of "invocationCount" value.
For example: If you want to create 50 Shopify store. Change this: @Test(invocationCount=50).
After run the "runCreateShopifyStore.xml", the data will be recorded automatically to storeData.csv file the directory: src/test/resources/
This file will contains the parameters of the stores that was created:

Store URL
Email
Store name
The password is same as the Constants.PASSWORD parameter

<b>II. Install Original app and select the plan. </b>

This feature will install the Original file and select the plan depends on the parameters on the readStoreData.csv file.
Go to Store Data sheet, select download as a CSV file then paste to the directory: project/src/test/resources.
The tool will read the parameters (Store URL, Email) to login to the Shopify store.
Then will install the Original app and select the plan depends on the "Store Type" column in the CSV file.

<b>III.Spam reaction on What's New posts </b>
1. Open class shopify > reactionRate.java and edit these parameters: 
- line 35: edit title parameter to the title of the post that you want to reaction.
- line 36: edit the title parameter to the title of the second post that you want to reaction.
2. Run reaction automation script by class test/resources/runReaction.xml > right click then select "Run runReaction.xml".

<b>IV. Website test cases </b>
There are 2 ways to run the test case: 
- Run by xml file (TestNG)
- Run by Cucumber

1. Run by xml file: 
Change the parameter that you want in the Constants class (main/commons/Constants).
Run the test case by right click on test/resources/runWebsiteTestcases.xml and select "Run runWebsiteTestcases.xml".
After run by the TestNG, the report will generate automate in the project folder/ExtentReportV3/ExtentReportV3.html.

2. Run by Cucumber:
You can reach the test scenario at test/features/Homepage.feature and WhatsNew.feature.
This file display as the Gherkin language and the non-tech user can reach normally.

- How to run test cases?
Reach file: test/java/cucumberOptions/CucumberTestRunner.java.
You can change some parameter to configure the test: change the parameter in tags parameter. 
- If you just want to run the Home page test cases: input "@HomePage".
- If you just want to run the Whats New test cases: input "@WhatsNewPage".
- If you want to run both of the testcases: input "@HomePage, @WhatsNewPage".
If your device was setup the Maven environment, you can run the test by using terminal: <b>mvn test verify </b>
After run test by the terminal, the Cucumber report will generate at: project folder/target/site/cucumber-reporting/cucumber-html-reports. Open the HTML files to show the report.

