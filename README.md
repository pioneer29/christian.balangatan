# christian.balangatan POM/Selenium Framework for Jupiter Toys web application

This project is based on the POM/Selenium Framework template that I have developed from the past.

Tools used:
- Eclipse 2021-03 (4.19.0)
- Maven: Apache Maven 3.8.1
- Java: AdoptOpenJDK 11.0.11

Main test is located in: src/test/java/com/JupiterToys_POMSeleniumFramework/tests/Tests_JupiterToys_Module1Test.java

Element locators and methods are located in src/main/java/com/JupiterToys_POMSeleniumFramework/pages:
- PO_Home.java - Locators and methods for the Home page
- PO_Contact.java - Locators and methods for the Contact page
- PO_Shop.java - Locators and methods for the Shop page

There are 2 options on How to run the test suite (src/test/resources/testsuite.xml:

1st Option:
- Go to src/test/resources/testsuites
- Right click testsuite.xml and Run as TestNG

2nd Option:
- From command prompt, go to the home directory of the project
- run this command: mvn install test -D TestSuite=testsuite.xml

*Extent Report Test Result is located in /reports
*There are 2 extent reports on the folder:
1. TestNG-JupiterToys_SeleniumFramework-Report_020322083353.html - result with failed test case (intentionally Failed the testcase just to check if validation for the expected quantity of the ordered item is working)
2. TestNG-JupiterToys_SeleniumFramework-Report_020322083531.html - result with all test cases passed

Test Data file is located in: src/test/resources/data/JupiterToys_DATA.xlsx
