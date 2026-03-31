package com.qacart.todo.util;

import io.restassured.http.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookiesUtils {

    public static List<org.openqa.selenium.Cookie> convertRestAssuredCookiesToSelenium (List<Cookie> restAssuredCookie)
    {

        List<org.openqa.selenium.Cookie> seleniumCookies = new ArrayList<>();
        for(Cookie cookie: restAssuredCookie)
        {

            org.openqa.selenium.Cookie seleniumCookie = new org.openqa.selenium.Cookie(cookie.getName(), cookie.getValue());

            seleniumCookies.add(seleniumCookie);

        }

        return seleniumCookies;

    }

}
