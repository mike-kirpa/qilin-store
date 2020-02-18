package com.projectname.appmanager;

import com.browserstack.local.Local;
import com.projectname.appmanager.helpers.AFile;
import com.projectname.appmanager.helpers.GetProperties;
import com.projectname.appmanager.helpers.Logging;
import com.projectname.appmanager.helpers.RestAPI;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

public class ApplicationManager {
    public WebDriver driver;
    private Local l;
    public GetProperties getProperties;
    public RestAPI restAPI;
    public AFile downloadAFile;
    public Logging logging;

    public void stop() {
    }

    public void init(String config_file, String environment, String zone) {
        getProperties = new GetProperties(zone);
        restAPI = new RestAPI();
        downloadAFile = new AFile();
        logging = new Logging();
    }
}
