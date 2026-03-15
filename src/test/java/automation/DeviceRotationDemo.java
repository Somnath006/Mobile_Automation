package automation;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DeviceRotationDemo {
    @Test
    public void deviceRoDemo() throws MalformedURLException, InterruptedException {

        //start the server
        AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Somnath\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        //set capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp("D://Mobile Automation//setup//Appium//Appium//src//test//java//resources//APiDemos-debug.apk");
        options.setDeviceName("Pixel 6");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);

        WebElement preferences = driver.findElement(AppiumBy.accessibilityId("Preference"));
        preferences.click();

        WebElement preferenceDependcies = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='3. Preference dependencies']"));
        preferenceDependcies.click();

        WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
        checkbox.click();

        DeviceRotation landScape = new DeviceRotation(0,0,90);
        driver.rotate(landScape);
        Thread.sleep(5000);
        WebElement wifiSettings = driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']"));
        wifiSettings.click();

        Thread.sleep(5000);

        driver.setClipboardText("Rahul Wifi");
        WebElement text = driver.findElement(By.id("android:id/edit"));
        text.sendKeys(driver.getClipboardText());

        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));

    }
}
