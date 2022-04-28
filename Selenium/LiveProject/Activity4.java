package LiveProject;

import activities.ActivitySample;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity4 extends ActivitySample {
    @Test
    public void verifySecondPopularCourse(){
        driver.get("https://alchemy.hguy.co/lms");
        String secondPopularCourse=driver.findElement(By.xpath("(//h3[@class='entry-title'])[2]")).getText();
        Assert.assertEquals(secondPopularCourse,"Email Marketing Strategies");
        driver.close();
    }
}
