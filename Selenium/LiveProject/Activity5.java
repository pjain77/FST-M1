package LiveProject;

import activities.ActivitySample;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity5 extends ActivitySample {
    @Test
    public void navigateToAnotherPage(){
        driver.get("https://alchemy.hguy.co/lms");
        Assert.assertEquals(driver.getTitle(),"Alchemy LMS – An LMS Application");
        driver.findElement(By.xpath("//a[text()='My Account']")).click();
        Assert.assertEquals(driver.getTitle(),"My Account – Alchemy LMS");
        driver.close();
    }
}
