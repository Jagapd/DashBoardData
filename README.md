# DashBoardData
DashBoard Data presented in HTML Format

Tech Stack :
1) Java,
2) Selenium,
3) TestNg,
4) Maven,
5) HTML,
6) Chrome browser(Headless)

How to run :
1) Install Java , Maven 
2) Clone the repo.
3) Import the maven dependency 

From command line type the below command. 
mvn clean test -DsuiteXmlFile=testng.xml 
 or
Setup the project in eclipse/Intellij and run the testng.xml file to get the results.
 
Output is printed in console log , in text file(DashBoardData.txt) , also in html file(DashBoardData.html).

 About Implementation :
 
 1) Extracted the text from source and did a parsing with help of regular expression to store the results in HashMap datastructure, finally print the result in console , HTML file , Text file 
 
 
 Sample output 
 
 In HTML 
 
 https://htmlpreview.github.io/?https://github.com/Jagapd/DashBoardData/blob/master/DashBoardData.html
 
In Console 
Value of Number of Different Grant Application
 1) Updates Required  : 21
2) Processing  : 357
3) Drafts  : 477
4) Completed  : 67
