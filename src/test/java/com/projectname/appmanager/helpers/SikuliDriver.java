package com.projectname.appmanager.helpers;

import org.sikuli.script.Screen;

public class SikuliDriver {


        private static Screen driver;

        public synchronized static Screen getInstance() {
            if (driver == null){
                driver = new Screen();
            }
            return driver;
        }
}
