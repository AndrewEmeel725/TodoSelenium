package com.qacart.todo.util;

import java.util.Properties;

public class ConfigUtils {

    private static Properties properties;
    private static ConfigUtils configUtils;

    private ConfigUtils() {

       String env= System.getProperty("env","PRODUCTION");
       switch (env)
       {
           case "PRODUCTION":
               properties = PropertiesUtil.loadUtils("src/test/java/com/qacart/todo/config/production.properties");
               break;
           case "LOCAL":
               properties = PropertiesUtil.loadUtils("src/test/java/com/qacart/todo/config/local.properties");
               break;
           default:
               throw new RuntimeException("Env is not Supported");

       }

    }

    public static ConfigUtils getInstance() {
        if (configUtils == null) {
            configUtils = new ConfigUtils();
        }
        return configUtils;

    }


    public  String getBaseUrl() {
        String prob = properties.getProperty("baseUrl");
        if (prob != null) return prob;
        throw new RuntimeException("Couldn't find the Baseurl in property file");


    }

    public  String getEmail()
    {
        String email= properties.getProperty("email");
        if ( email != null) return email;
        throw new RuntimeException("Couldn't find the email in property file");
    }

    public  String getPassword()
    {
        String password= properties.getProperty("password");
        if ( password != null) return password;
        throw new RuntimeException("Couldn't find the password in property file");
    }
}




