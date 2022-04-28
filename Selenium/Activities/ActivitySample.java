package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActivitySample {
    public WebDriver driver;

    @BeforeClass
    public void setUp(){
        //Initialize driver object
        driver=new FirefoxDriver();
    }

    @Test
    public void homePageTest(){
        //Get page title
       String homePageTitle= driver.getTitle();

       //Assertion for home page title
        Assert.assertEquals(homePageTitle,"Training Support");

        //Find and click about Us Link
        driver.findElement(By.id("about-link")).click();

        //Find About us page title
        String aboutUsPageTitle= driver.getTitle();
        Assert.assertEquals(aboutUsPageTitle,"About Training Support");
    }

    @AfterClass
    public void tearDown(){
        //Close the browser
       // driver.close();
    }
}
