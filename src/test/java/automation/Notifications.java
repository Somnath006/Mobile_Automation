package automation;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Notifications {


    @Test
    public void notifcationDemo() throws MalformedURLException, InterruptedException {


        //start the server
        AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Somnath\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        //set capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp("D://Mobile Automation//setup//Appium//Appium//src//test//java//resources//APiDemos-debug.apk");
        options.setDeviceName("Pixel 6");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);


        driver.openNotifications();
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 0,
                "top", 0,
                "width", 200,
                "height", 800,
                "direction", "down",
                "percent", 0.8
        ));
        Thread.sleep(5000);

        Dimension size = driver.manage().window().getSize();
        ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",ImmutableMap.of(
                "left",0,
                "top",0,
                "width",size.width,
                "height",size.height,
                "direction","left",
                "percent",0.75));

        Thread.sleep(5000);
        driver.lockDevice();
        Thread.sleep(5000);
        driver.unlockDevice();
    }

}
