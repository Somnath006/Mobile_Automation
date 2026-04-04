package automation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WebApplication {

    @Test
    public void webDemo() throws MalformedURLException {

        //start the server
        AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Somnath\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        //set capability
        UiAutomator2Options options = new UiAutomator2Options();
        options.setChromedriverExecutable("C:\\Users\\Somnath\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        options.setDeviceName("Pixel 6");
        options.setCapability("browserName","chrome");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

        WebElement hamburgerButton = driver.findElement(By.cssSelector("span[class='navbar-toggler-icon']"));
        hamburgerButton.click();

        WebElement products = driver.findElement(By.xpath("//div[@id='navbarSupportedContent']//a[@routerlink='/products']"));
        products.click();

        WebElement devopsText = driver.findElement(By.xpath("//a[text()='Devops']"));


//        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",devopsText);

        String text = devopsText.getText();
        Assert.assertEquals(text,"Devops");



    }

}
