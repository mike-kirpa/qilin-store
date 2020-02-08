package com.projectname.tests;

import com.projectname.appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected  ApplicationManager app = new ApplicationManager();

    @BeforeMethod(alwaysRun = true)
    @org.testng.annotations.Parameters(value = { "config", "environment", "zone"})
    @SuppressWarnings("unchecked")
    public void setUp(String config_file, String environment, String zone) throws Exception {
        app.init(config_file, environment, zone);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

}
