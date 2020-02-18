package com.projectname.appmanager.pages.app;

import com.projectname.appmanager.ApplicationManager;
import com.projectname.appmanager.helpers.GetProperties;
import com.projectname.appmanager.helpers.Logging;
import com.projectname.appmanager.helpers.SikuliDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.util.logging.Logger;

public class AbstractAppPage {
    private static Logger log = Logger.getLogger(AbstractAppPage.class.getName());

    public static Pattern logoRamblerGames = new Pattern(GetProperties.path("app_img/logo_rambler_games.png"));
    public static Pattern AlphaChanel = new Pattern(GetProperties.path("app_img/alpha_chanel.png"));
    public static Pattern BetaChanel = new Pattern(GetProperties.path("app_img/beta_chanel.png"));
    public static Pattern LatestChanel = new Pattern(GetProperties.path("app_img/latest_chanel.png"));
    public static Pattern AlphaChanekInList = new Pattern(GetProperties.path("app_img/alpha_chanel_in_list.png"));
    public static Pattern BetaChanekInList = new Pattern(GetProperties.path("app_img/beta_chanel_in_list.png"));
    public static Pattern LatestChanekInList = new Pattern(GetProperties.path("app_img/latest_chanel_in_list.png"));
    public static Pattern DownloadAndInstallButton = new Pattern(GetProperties.path("app_img/download_and_install.png"));
    public static Pattern DownloadAndInstall2RowsButton = new Pattern(GetProperties.path("app_img/download_and_install_2rows.png"));

    protected final static int WIN_TIMEOUT = Integer.parseInt(GetProperties.value("window.timeout"));
    protected final static int CTL_TIMEOUT = Integer.parseInt(GetProperties.value("control.timeout"));

    public static boolean isElementPresent(Pattern pattern) throws FindFailed {
        try{
            getDriver().wait(pattern, CTL_TIMEOUT);
            return true;
        } catch (FindFailed e) {
            return false;
        }

    }

    public static boolean isPagePresent(Pattern pattern) throws FindFailed {
        try{
            getDriver().wait(pattern, CTL_TIMEOUT);
            return true;
        } catch (FindFailed e) {
            return false;
        }

    }

    public static boolean waitWhilePageNotPresent(Pattern pattern) throws FindFailed {
            while(true){
                if(getDriver().exists(pattern) != null){getDriver().wait(1.00);}
                else break;
            }
            return true;
    }


    public static boolean isPageLoaded(Pattern pattern) throws FindFailed {
        try{
            getDriver().wait(pattern, WIN_TIMEOUT);
            return true;
        } catch (FindFailed e) {
            return false;
        }

    }

    public static void clickOnElement(Pattern pattern) throws FindFailed {
        try{
            getDriver().click(pattern, WIN_TIMEOUT);
            log.info("Click on " + pattern.toString() + " element");
        } catch (FindFailed e) {
            log.info("I can'r click on" + pattern.toString() + " element");
        }
    }
    protected static Screen getDriver() {
        return SikuliDriver.getInstance();
    }
}
