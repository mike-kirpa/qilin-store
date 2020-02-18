package com.projectname.appmanager.helpers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GetProperties {
    String filename;
    //файл, который хранит свойства нашего проекта
    public static Properties properties = new Properties();

    public GetProperties(String filename)  {
        File file = new File("src/test/resources/EnvironmentVariables/" + filename +".properties");
        this.filename = filename;
        try {
            properties.load(new FileReader(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String value (String key){
        return properties.getProperty(key);
    }

    public static String getPathFor(String file) {
        // Using substring for full path to remove first slash.
        // Sikuli bug on Windows
        return ClassLoader.getSystemResource(file).getPath().toString().substring(1);
    }

    public static String path(String file) {
        return getPathFor(file);
    }
}
