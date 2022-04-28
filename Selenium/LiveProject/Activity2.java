package LiveProject;

import activities.ActivitySample;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity2 extends ActivitySample {
    @Test
    public void verifyWebsiteHeading(){
        driver.get("https://alchemy.hguy.co/lms");
        String websiteHeading=driver.findElement(By.xpath("//h1[contains(@class,'title')]")).getText();
        Assert.assertEquals(websiteHeading,"Learn from Industry Experts");
        driver.close();
    }
}
