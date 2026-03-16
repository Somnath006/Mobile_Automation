package automation;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppActivity {

    @Test
    public void appPackageAndAppActivity() throws MalformedURLException, InterruptedException {

        //start the server

        AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Somnath\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        //set capability
        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp("D://Mobile Automation//setup//Appium//Appium//src//test//java//resources//APiDemos-debug.apk");
        options.setDeviceName("pixel 6");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);

        Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");

        ((JavascriptExecutor)driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));

//        DeviceRotation landScape = new DeviceRotation(0,0,90);
//        driver.rotate(landScape);
        Thread.sleep(2000);
        WebElement checkBox = driver.findElement(By.id("android:id/checkbox"));
        checkBox.click();

        WebElement wifiButton = driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']"));
        wifiButton.click();

        driver.setClipboardText("Rahul Wifi");

        WebElement textField = driver.findElement(By.className("android.widget.EditText"));
        textField.sendKeys(driver.getClipboardText());

        WebElement okButton = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/button1\")"));

        okButton.click();

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));



    }
}
