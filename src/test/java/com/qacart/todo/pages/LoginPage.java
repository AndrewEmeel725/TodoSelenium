package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.util.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver)
    {
        super(driver);// will get construct of page from basepage
    }



    @FindBy(css = "[data-testid=\"email\"]")
    private WebElement emailInput;

    @FindBy(css = "[data-testid=\"password\"]")
    private WebElement passwordInput;

    @FindBy(css = "[data-testid=\"submit\"]")
    private WebElement submitButton;

    @Step
    public TodoPage login (String email, String password)
    {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitButton.click();
        return new TodoPage(driver);
    }

    @Step
    public LoginPage load()
    {
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        return this;
    }

}
