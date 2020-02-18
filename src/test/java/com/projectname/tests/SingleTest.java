package com.projectname.tests;

import com.projectname.appmanager.helpers.Locators;
import com.projectname.appmanager.pages.app.AbstractAppPage;
import com.projectname.appmanager.pages.app.MainAppPage;
import org.openqa.selenium.WebElement;
import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class SingleTest extends TestBase {

    @Test()
    public void test() throws InterruptedException, IOException, FindFailed {
        String absolutePath = app.downloadAFile.downloadUrlAsFile(app.getProperties.value("DonloadURL"), app.getProperties.value("DownloadFileName"), app.getProperties.value("DownloadFolder"));
        App.open(absolutePath);
        MainAppPage mainAppPage = new MainAppPage();
        while (System.currentTimeMillis() / 1000L < 1582156800) {
            mainAppPage.clickOnAlphaChanelButton();
            mainAppPage.clickOnBetaChanelInList();
            mainAppPage.clickOnDownLoadAndInstallButton();
            mainAppPage.waitWhilePageNotPresent();
            Assert.assertTrue(mainAppPage.isMainPageLoaded(), "App don't uppdated");
            mainAppPage.clickOnBetaChanelButton();
            mainAppPage.clickOnLatestChanelInList();
            mainAppPage.clickOnDownLoadAndInstallButton();
            mainAppPage.waitWhilePageNotPresent();
            Assert.assertTrue(mainAppPage.isMainPageLoaded(), "App don't uppdated");
            mainAppPage.clickOnLatestChanelButton();
            mainAppPage.clickOnAlphaChanelInList();
            mainAppPage.clickOnDownLoadAndInstallButton();
            mainAppPage.waitWhilePageNotPresent();
            Assert.assertTrue(mainAppPage.isMainPageLoaded(), "App don't uppdated");
        }
    }
}
