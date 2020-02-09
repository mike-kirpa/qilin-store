package com.projectname.tests.suite;

import com.projectname.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuiteTest08 extends TestBase {

    @Test
    public void test_08() throws Exception {
        app.driver.get("https://www.google.com/ncr");
        Thread.sleep(3000);
        WebElement element = app.driver.findElement(By.name("q"));
        element.sendKeys("BrowserStack Test 08");
        element.submit();
        Thread.sleep(3000);

        Assert.assertEquals("BrowserStack Test 08 - Google Search", app.driver.getTitle());
    }
}
