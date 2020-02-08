package com.projectname.appmanager.pages;

import com.projectname.appmanager.helpers.Locators;
import org.openqa.selenium.WebDriver;



public class PayFormPage extends AbstractPage{
    public PayFormPage(WebDriver driver){
        super(driver);
        waitForPageLoad("DemoFormPage.formLayout");
    }

    public void selectCountry(){
        if(isElementPresent("DemoFormPage.formWarningArea") & isElementPresent("DemoFormPage.countrySelectField")){
            driver.findElement(Locators.get("DemoFormPage.countrySelectField")).click();
        }
    }

    public void selectLanguage(){
        String lang = driver.findElement(Locators.get("DemoFormPage.languageSelectField")).getText();
        System.out.println(lang);

    }
}
