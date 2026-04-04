package com.mobile.automation.pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    AndroidDriver driver;

    public LoginPage(AndroidDriver driver){

        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    private WebElement countryDropdown;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))")
    private WebElement scrollDropdown;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='India']")
    private WebElement IndiaOption;

    @AndroidFindBy (className = "android.widget.EditText")
    private WebElement text;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.androidsample.generalstore:id/radioMale\")")
    private WebElement radioButtonMale;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.androidsample.generalstore:id/radioFemale\")")
    private WebElement radioButtonFemale;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement letsShopButton;

    public void setNameFiled(String name){
        text.sendKeys(name);
        driver.hideKeyboard();
    }
    public void setDropdown(){
        countryDropdown.click();
    }
    public void letsShop(){
        IndiaOption.click();
        radioButtonFemale.click();
        letsShopButton.click();
    }

}
