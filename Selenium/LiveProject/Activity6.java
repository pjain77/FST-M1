package LiveProject;

import activities.ActivitySample;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity6 extends ActivitySample {
    @Test
    public void loginToLMSWebSite(){
        driver.get("https://alchemy.hguy.co/lms");
        Assert.assertEquals(driver.getTitle(),"Alchemy LMS – An LMS Application");
        driver.findElement(By.xpath("//a[text()='My Account']")).click();
        Assert.assertEquals(driver.getTitle(),"My Account – Alchemy LMS");
        //Clicking on login button
        driver.findElement(By.xpath("//*[text()='Login']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user_login"))));
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Logout']")).isDisplayed());
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()='Logout']"))));


        driver.close();
    }
}
