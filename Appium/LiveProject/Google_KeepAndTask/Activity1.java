package LiveProject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class Activity1 {
    AndroidDriver<MobileElement> driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        //Desrired Capibilities
        System.out.println("Starting Appium Server on Localhost");
        AppiumDriverLocalService appiumDriverLocalService;
        HashMap<String, String> environment = new HashMap<>();
        environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
        AppiumServiceBuilder builder =
                new AppiumServiceBuilder()
                        .withAppiumJS(new File("/Applications/Appium Server GUI.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
                        .withArgument(GeneralServerFlag.RELAXED_SECURITY)
                        .usingAnyFreePort()
                        .withEnvironment(environment);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "warn");
        appiumDriverLocalService = AppiumDriverLocalService.buildService(builder);
        appiumDriverLocalService.start();
        System.out.println("Appium Server Started at......"
                + appiumDriverLocalService.getUrl());
        //URL serverURL= new URL("https://localhost:4723/wd/hub");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("deviceName", "Pixel 4 API 28");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", "true");


        driver = new AndroidDriver<MobileElement>(appiumDriverLocalService.getUrl(), caps);
    }

    @Test
    public void createActivityList() throws InterruptedException {
        //driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Get started\")").click();
        Thread.sleep(5000);

        //New task btn
        MobileElement newTaskBtn = driver.findElementByAccessibilityId("Create new task");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(newTaskBtn));
        //Adding 1st task
        newTaskBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
        //adding  task
        driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Tasks");
        //Clicking save btn
        driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.google.android.apps.tasks:id/add_task_done\")").click();

        //Adding 2nd task
        newTaskBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
        //adding task
        driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Keep");
        //Clicking save btn
        driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.google.android.apps.tasks:id/add_task_done\")").click();

        //Adding 3rd task
        newTaskBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
        //adding task
        driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete the second Activity Google Keep");
        //Clicking save btn
        driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.google.android.apps.tasks:id/add_task_done\")").click();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

