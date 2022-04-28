package activities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    AndroidDriver<MobileElement> driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        //Desrired Capibilities
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("deviceName","Pixel_4_API_28");
        caps.setCapability("appPackage","com.android.calculator2");
        caps.setCapability("appActivity",".Calculator");
        caps.setCapability("noReset","true");
        URL serverURL= new URL("https://localhost:4723/wd/hub");


        driver= new AndroidDriver<MobileElement>(serverURL,caps);
    }

    @Test
    public void multiplicationTest(){
         MobileElement ele=driver.findElementById("digit_5");
         ele.click();
         driver.findElementByAccessibilityId("mutilply").click();
         ele.click();
         driver.findElementById("equals").click();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
