package com.projectname.appmanager.pages.app;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Region;

public class MainAppPage extends AbstractAppPage{

    private Region window;

    public MainAppPage(){
        try {
            AbstractAppPage.isPageLoaded(PopularTitle);
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }

    public void clickOnAlphaChanelButton() throws FindFailed {

        AbstractAppPage.clickOnElement(AlphaChanel);
    }
    public void clickOnBetaChanelButton() throws FindFailed {
        AbstractAppPage.clickOnElement(BetaChanel);
    }
    public void clickOnLatestChanelButton() throws FindFailed {
        AbstractAppPage.clickOnElement(LatestChanel);
    }
    public void clickOnAlphaChanelInList() throws FindFailed {
        AbstractAppPage.clickOnElement(AlphaChanekInList);
    }
    public void clickOnBetaChanelInList() throws FindFailed {
        AbstractAppPage.clickOnElement(BetaChanekInList);
    }
    public void clickOnLatestChanelInList() throws FindFailed {
        AbstractAppPage.clickOnElement(LatestChanekInList);
    }
    public void clickOnDownLoadAndInstallButton() throws FindFailed {
        if(AbstractAppPage.isElementPresent(DownloadAndInstall2RowsButton))AbstractAppPage.clickOnElement(DownloadAndInstall2RowsButton);
        else AbstractAppPage.clickOnElement(DownloadAndInstallButton);
    }
    public boolean isMainPageLoaded() throws FindFailed {
        return AbstractAppPage.isPageLoaded(PopularTitle);
    }
    public void waitWhilePageNotPresent() throws FindFailed {
        AbstractAppPage.waitWhilePageNotPresent(PopularTitle);
    }

    public void  waitPagePresent() throws FindFailed {
        AbstractAppPage.isPageLoaded(logoRamblerGames);
    }
}
