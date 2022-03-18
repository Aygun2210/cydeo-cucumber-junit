package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
       /*
    Creating a private constructors we are closing
     access to the object of this class from outside the class
     */

    private Driver(){}

    /*
    we make webdriver private, bc we want to close the access from outside the class
    we make it static bc we are going use it in static method
     */
    private static WebDriver driver;

    /*
    create a reusable utility method which will return same driver instance when we call it
     */
    public static WebDriver getDriver(){
        if (driver == null){

            //we read our browser type from configuration. properties.
            //this way we can control which browser is opened from outside our code
            String browserType= ConfigurationReader.getProperty("browser");
/*
                Depending on the browserType that will be return from configuration.properties file
                switch statement will determine the case, and open the matching browser
            */

            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver= new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver= new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver= new OperaDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;


            }
        }
        return driver;

    }

    //driver.quit()---> nosucsession
    //driver.close()

    //this method will make sure our driver value is always null after using quit method

    public static void closeDriver(){
        if (driver != null){
            driver.quit();  //this line will terminate the exicting method , value is not even null
            driver = null;
        }

    }
}
