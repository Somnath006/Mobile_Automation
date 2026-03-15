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
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class SwipeGesture {

    @Test
    public void swipeDemo() throws MalformedURLException {

        //Start the server

        AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Somnath\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        //Set Capability

        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp("D://Mobile Automation//setup//Appium//Appium//src//test//java//resources//APiDemos-debug.apk");
        options.setDeviceName("Pixel 6");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        WebElement view = driver.findElement(AppiumBy.accessibilityId("Views"));
        view.click();

        WebElement gallery = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Gallery\"]"));
        gallery.click();

        WebElement photos = driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']"));
        photos.click();

        WebElement firstImage = driver.findElement(By.xpath("//android.widget.Gallery[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]"));

        List<WebElement> images = driver.findElements(By.xpath("//android.widget.Gallery[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView"));

        int imageSize = images.size();
        System.out.println(imageSize);

        int width = firstImage.getSize().getWidth();
        System.out.println(width);

        String focusable = firstImage.getAttribute("focusable");

        Assert.assertEquals(focusable,"true");

    for(WebElement image : images) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement) image).getId(), "direction", "left", "percent", 0.30));

        Assert.assertEquals(image.getAttribute("focusable"), "false");

    }

    }
}
