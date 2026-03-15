package automation;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
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

public class DragDropGesture {

    @Test
    public void dragAndDrop() throws MalformedURLException, InterruptedException {

        //start the server

        AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Somnath\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        // set capabilities

        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp("D://Mobile Automation//setup//Appium//Appium//src//test//java//resources//APiDemos-debug.apk");
        options.setDeviceName("pixel 6");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);

        WebElement views = driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
        views.click();

        WebElement dragAndDrop = driver.findElement(AppiumBy.accessibilityId("Drag and Drop"));
        dragAndDrop.click();

        WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

        ((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of("elementId", ((RemoteWebElement)source).getId(),"endX",623,"endY",614));

        WebElement dropped = driver.findElement(By.xpath("//android.widget.TextView[@text='Dropped!']"));

        String droppedText = dropped.getText();
        Assert.assertEquals(droppedText,"Dropped!");
    }
}
