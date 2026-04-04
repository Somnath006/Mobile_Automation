package automation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.print.DocFlavor;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ToastMessage {

    @Test
    public void toastDemo() throws MalformedURLException {

        //start the server
        AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Somnath\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        //set capability
        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp("D:\\Mobile Automation\\setup\\APKFiles\\resources\\General-Store.apk");
        options.setDeviceName("Pixel 6");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement letsGoButton = driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(letsGoButton));
        letsGoButton.click();
        WebElement toastMessage = driver.findElement(By.xpath("//android.widget.Toast[@text='Please enter your name']"));
        String toast = toastMessage.getText();
        System.out.println(toast);

        Assert.assertEquals(toast,"Please enter your name");
    }
}
