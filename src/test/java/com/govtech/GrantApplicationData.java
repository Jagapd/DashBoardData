package com.govtech;


import com.bgp.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class GrantApplicationData {


    public WebDriver driver;
    private String URL="https://public:Let$BeC001@bgp-qa.gds-gov.tech/";
    private String FileName="DashBoardData.txt";
    private String htmlFileName="DashBoardData.html";
    private static String driverPath = System.getProperty("user.dir")+"/Drivers/chromedriver";
    HashMap<String,String > grantsData=new HashMap<String, String>();
    private String preferredUser="S9111111A - 197702066M";
    HomePage home;

    @BeforeTest
    public final void connect() {
        System.out.println("launching chrome browser");
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("start-maximized");
        options.addArguments("window-size=1920x1080");
        driver = new ChromeDriver(options);
    }

    /*
        Open the url https://public:Let$BeC001@bgp-qa.gds-gov.tech/
        click on login button
        select preferred user and login

     */

    @Test
    void GetGrantApplicationData() throws IOException {
        home = new HomePage(driver);
        driver.get(URL);
        home.clickOnLoginButton();
        home.loginWithPreferredUserId(preferredUser);
        home.waitForGrantToAppear();
        for (int i = 1; i <= 4; i++) {
            String data = driver.findElement(By.xpath("//*[@id=\"grants\"]/div[3]/section[1]/ul/li[" + i + "]")).getText();
            String parsedData = data.replaceAll("[^a-zA-Z0-9\\s+]", "");
            String[] parts = parsedData.split("(?<=\\D)(?=\\d)");
            grantsData.put(parts[0], parts[1]);
        }

        /*
            DashBoard Data Stored in File After Parsing
         */
        PrintStream o = new PrintStream(new File(FileName));
        PrintStream console = System.out;
        System.setOut(o);
        System.out.println("Value of Number of Different Grant Application");
        for (Map.Entry<String, String> entry : grantsData.entrySet()) {
            System.setOut(o);
            System.out.println(entry.getKey() + " : " + entry.getValue());
            System.setOut(console);
        }

        /*
            Printing in console logs after parsing
         */

        System.out.println("Value of Number of Different Grant Application");
        for (Map.Entry<String, String> entry : grantsData.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


        /*
         Data Printed in Html after parsing in Tabular format

         */

        String htmlHeader=null, htmlBody=null, htmlFooter=null;
        OutputStream htmlfile = null;
        htmlfile = new FileOutputStream(new File(htmlFileName));
        PrintStream printhtml = new PrintStream(htmlfile);
        //--Setting up HTML header content
        htmlHeader="<html><head><meta charset='utf-8'><title>DashBoard Data</title></head>";
        htmlBody="<body><table align='center' border='1' style='width:25%'><tr><th>Grants Data<th>Count</th></tr>";
        htmlFooter="</body></html>";
        for (Map.Entry<String, String> entry : grantsData.entrySet()) {
            htmlBody+="<tr><td>"+entry.getKey()+"</td><td>"+entry.getValue()+"</td>";
        }
        htmlBody+="</tr>";
        htmlBody+="</table>";
        printhtml.println(htmlHeader+htmlBody+htmlFooter);
        printhtml.close();
        htmlfile.close();

    }


    @AfterTest
    public void closeBrowser()
    {
        driver.quit();
    }





}
