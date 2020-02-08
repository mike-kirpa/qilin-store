package tests.suite;

import com.paysuper.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuiteTest07 extends TestBase {

    @Test
    public void test_07() throws Exception {
        app.driver.get("https://www.google.com/ncr");
        WebElement element = app.driver.findElement(By.name("q"));
        element.sendKeys("BrowserStack Test 07");
        element.submit();
        Thread.sleep(3000);

        Assert.assertEquals("BrowserStack Test 07 - Google Search", app.driver.getTitle());
    }
}
