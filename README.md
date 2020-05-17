# DashBoardData
DashBoard Data presented in HTML Format

Tech Stack :
Java
Selenium
TestNg
HTML

How to run :

Install Java , Maven 
Clone the repo.
import the maven dependency 

From command line
mvn clean test -DsuiteXmlFile=testng.xml 
 or
 Setup the project in eclipse/Intellij and run the testng.xml file to get the results.
 
 Output is printed in console log , in text file(DashBoardData.txt) , also in html file(DashBoardData.html).
 
 About implementeation :
 
 1) Extracted the text from source and did a parsing with help of regular expression to store the results in HashMap datastructure, finially print the result in console , HTML file , Text file 
 
 
 Sample output 
 
 In HTML 
 
 https://htmlpreview.github.io/?https://github.com/Jagapd/DashBoardData/blob/master/DashBoardData.html
 
In Console 
Value of Number of Different Grant Application
Updates Required  : 21
Processing  : 357
Drafts  : 477
Completed  : 67
