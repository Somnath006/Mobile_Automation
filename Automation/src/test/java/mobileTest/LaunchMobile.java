package mobileTest;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class LaunchMobile {
  public static void main(String[]srgs) throws MalformedURLException {
//	AppiumDriverLocalService service =
//			new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingPort(4723).build();
//	
//	service.start();
	
	 UiAutomator2Options options = new UiAutomator2Options();

     options.setPlatformName("Android");
     options.setDeviceName("emulator-5554");
     options.setAutomationName("UiAutomator2");
     options.setAppPackage("com.android.calculator2");
     options.setAppActivity("com.android.calculator2.Calculator");

     AndroidDriver driver =
     new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	
		        
	}   

}
