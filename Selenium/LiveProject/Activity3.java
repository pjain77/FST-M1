package LiveProject;

import activities.ActivitySample;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity3 extends ActivitySample {
    @Test
    public void verifyFirstInfoBoxTitle(){
        driver.get("https://alchemy.hguy.co/lms");
        String firstInfoBoxTitle=driver.findElement(By.xpath("//h3[contains(@class,'ifb-title')]")).getText();
        Assert.assertEquals(firstInfoBoxTitle,"Actionable Training");
        driver.close();
    }
}
