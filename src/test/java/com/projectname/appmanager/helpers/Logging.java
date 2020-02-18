package com.projectname.appmanager.helpers;

import com.projectname.appmanager.ApplicationManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Logging {
    private static final LogManager logManager = LogManager.getLogManager();
    private static final Logger LOGGER = Logger.getLogger("confLogger");
    public Logging() {
            try {
                logManager.readConfiguration(new FileInputStream("logging.properties"));
            } catch (IOException exception) {
                LOGGER.log(Level.SEVERE, "Error in loading configuration",exception);
            }

    }
}
