# christian.balangatan POM/Selenium Framework for Jupiter Toys web application

Tools used:
- Eclipse 2021-03 (4.19.0)
- Maven: Apache Maven 3.8.1
- Java: AdoptOpenJDK 11.0.11

Main test is located in: src/test/java/com/JupiterToys_POMSeleniumFramework/tests/Tests_JupiterToys_Module1Test.java

There are 2 options on How to run the test suite (src/test/resources/testsuite.xml:

1st Option:
- Go to src/test/resources/testsuites
- Right click testsuite.xml and Run as TestNG

2nd Option:
- From command prompt, go to the home directory of the project
- run this command: mvn install test -D TestSuite=testsuite.xml

*Extent Test Result is located in /reports
*There are 2 extent reports on the folder:
1. TestNG-JupiterToys_SeleniumFramework-Report_020322083353.html - result with failed test case (intentionally Failed the testcase just to check if validation for the expected quantity of the ordered item is working)
2. TestNG-JupiterToys_SeleniumFramework-Report_020322083531.html - result with all test cases passed
