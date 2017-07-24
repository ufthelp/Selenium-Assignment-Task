# Selenium-Project-Task
This assignment covers the automation framework designing using Selenium.
# Automation using Selenium API
Perquisites Technology stack:-
*Eclipse	                 IDE
*Selenium webdriver	     Using Selenium API's for automating the UI
*Log4j 	                 Logging Test cases execution status
*TestNG	                 Unit testing Framework

Test Scenario that is automated:-
Write a Selenium web driver test suite using Java that will go to http://automationpractice.com/ and make a purchase
* Create a new account
* Make a purchase
* Verify final price

The test code should accomplish the following:
* Create an account
* Verify that an error will occur if the Zip/Postal Code is omitted during registration
* Verify that the a Blue Faded Shirt Sleeve T-shirt can be purchased in Medium size and delivered by “My carrier Delivery next day!”
* Verify the cost is  $18.51 with tax included

Overall Approach:- 
Easy maintainable and reusable code. Separating the implementation part from specifications.
How that is achieved:-
Separate object properties file.
Page object pattern - classes at page level, containing the reusable members
Better logging for each execution status using log4j
Exception handling 
testNg unit testing framework for better execution and result reporting.
Screenshot caputuring incase of errors.


Things to improve:-
Data driving the test scenario from external data source, say excel (using Apache POI/ jexcel)

