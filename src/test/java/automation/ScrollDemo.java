package automation;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.FileHandler;

public class ScrollDemo {

       @Test
    public void scrollOperation() throws IOException {

           //Start the server

           AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Somnath\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
           service.start();

           //Set Capabilities

           UiAutomator2Options options = new UiAutomator2Options();
           options.setApp("D://Mobile Automation//setup//Appium//Appium//src//test//java//resources//APiDemos-debug.apk");
           options.setDeviceName("Pixel 6");

           AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);

           WebElement view = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
           view.click();

           File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

           File dest = new File("D:\\Screenshots\\test.png");
           Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

    //       driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
           boolean scroll;
           do
           {
               scroll = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
           }while(scroll);

           File source1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

           File dest1 = new File("D:\\Screenshots\\test1.png");
           Files.copy(source1.toPath(), dest1.toPath(), StandardCopyOption.REPLACE_EXISTING);
       }
}
