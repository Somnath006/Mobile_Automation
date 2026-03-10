package automation;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ClickMethod {

    @Test
    public void clickElement() throws MalformedURLException {

        //start the server

        AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Somnath\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();

        service.start();

        //set Capabilities

        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp("D://Mobile Automation//setup//Appium//Appium//src//test//java//resources//APiDemos-debug.apk");
        options.setDeviceName("Pixel 6");

        AndroidDriver driver = new AndroidDriver (new URL("http://127.0.0.1:4723"),options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement preference = driver.findElement(AppiumBy.accessibilityId("Preference"));
        preference.click();

        WebElement preferenceDepencies = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]"));
        preferenceDepencies.click();

        WebElement wifiCheckBox = driver.findElement(By.id("android:id/widget_frame"));
        wifiCheckBox.click();

        WebElement wifiSetting = driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']"));
        wifiSetting.click();

        WebElement popText = driver.findElement(By.className("android.widget.EditText"));
        popText.sendKeys("Abc Wifi");

        WebElement wifiText = driver.findElement(By.id("android:id/alertTitle"));

        String text = wifiText.getText();
        Assert.assertEquals(text,"WiFi settings");

        WebElement popButton = driver.findElement(By.xpath("//android.widget.Button[@text='OK']"));
        popButton.click();


        driver.quit();

        service.stop();




    }
}
