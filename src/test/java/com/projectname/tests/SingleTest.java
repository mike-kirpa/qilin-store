package com.projectname.tests;

import com.projectname.appmanager.helpers.Locators;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SingleTest extends TestBase {

    @Test()
    public void test() throws InterruptedException {
        app.driver.get(app.getProperties.value("URL"));
        WebElement element = app.driver.findElement(Locators.get("q"));
        element.sendKeys(app.getProperties.value("SearchingRequest"));
        element.submit();
        Thread.sleep(5000);

        Assert.assertEquals(app.getProperties.value("ExpectedTitleBrowserStack"), app.driver.getTitle());
    }
}
