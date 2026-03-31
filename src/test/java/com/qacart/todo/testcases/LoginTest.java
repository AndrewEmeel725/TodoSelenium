package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.util.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


@Feature("Auth")
public class LoginTest extends BaseTest {



    @Story("Login using Email and Password")
    @Description("It will Login by Filling the Email and Password and navigate to the Todo Page")
    @Test(description = "Test login functionality using email and Password")
    public void shouldBeAbleToLoginWithEmailAndPassword()
    {

        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(
                loginPage
                .load()
                .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                .isWelcomeMessageDisplayed());




    }
}
