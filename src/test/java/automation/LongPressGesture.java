package automation;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class LongPressGesture {

    @Test
    public void longPressDemo() throws MalformedURLException {

        //Start the server

        AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Somnath\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        //Set Capability

        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp("D://Mobile Automation//setup//Appium//Appium//src//test//java//resources//APiDemos-debug.apk");
        options.setDeviceName("Pixel 6");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);

        WebElement view = driver.findElement(AppiumBy.accessibilityId("Views"));
        view.click();

        WebElement expandableList = driver.findElement(AppiumBy.accessibilityId("Expandable Lists"));
        expandableList.click();

        WebElement customAdaptor = driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']"));

        customAdaptor.click();

        WebElement peopleNames = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));


        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement)peopleNames).getId(), "duration",2000));
        WebElement sampleMenu = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Sample menu\"]"));
        String menu = sampleMenu.getText();
        Assert.assertEquals(menu, "Sample menu");
        Assert.assertTrue(sampleMenu.isDisplayed());






    }
}
