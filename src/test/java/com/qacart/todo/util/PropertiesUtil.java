package com.qacart.todo.util;

import java.io.*;
import java.util.Properties;

public class PropertiesUtil {

    public static Properties loadUtils(String path)
    {
        File file = new File(path);
        try {
            InputStream inputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
            return properties;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File is Not Found");
        } catch (IOException e) {
            throw new RuntimeException("Error with loading the property");
        }



    }

}
