# XEROwebsite
Serenity BDD project for XERO web application
This project illustrates the Serenity BDD reporting and living documentation features.

Get the code
Git:
git clone https://github.com/Joekannan/XEROwebsite.git
Or simply download a zip file.

Use Maven
Open a command window and run:

To Run the test - 
1. Navigate to the directory where project's pom.xml resides and run the below command
mvn clean verify
This runs Cucumber features using Cucumber's JUnit runner. The @RunWith(CucumberWithSerenity.class) annotation on the CucumberTestSuite class tells JUnit to kick off Cucumber.
2. Open Eclipse or any other IDE and run from "TestRunners.java" which is under "src\test\java\com\xero\web\testrunner\TestRunners.java"

Viewing the reports
Both of the commands provided above will produce a Serenity test report in the "target/site/serenity" directory if tests are run using option 2 and "\reports\Another folder with TimeStamp" if tests are run using option 1.
Go take a look! Note that these tests contain deliberate errors and failures to illustate how Serenity reports errors.

To learn more
You can learn more about the living documentation features of Serenity in the Serenity BDD Book.

About
No description, website, or topics provided.
Resources
 Readme
License
 Apache-2.0 License
Releases
No releases published
Packages
No packages published
Languages
Gherkin
55.8%
 
Java
44.0%
 
HTML
0.2%
