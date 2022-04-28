package LiveProject;

import activities.ActivitySample;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity1 extends ActivitySample {

    @Test
    public void verifyWebsiteTitle(){
        driver.get("https://alchemy.hguy.co/lms");
        String websiteTitle= driver.getTitle();
        Assert.assertEquals(websiteTitle,"Alchemy LMS – An LMS Application");
        driver.close();
    }
}
