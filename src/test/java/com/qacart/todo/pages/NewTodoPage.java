package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.util.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTodoPage extends BasePage {

    public NewTodoPage (WebDriver driver)
    {
        super(driver);
    }



    @FindBy(css = "[data-testid=\"new-todo\"]")
    private WebElement addTodoName;

    @FindBy(css = "[data-testid=\"submit-newTask\"]")
    private WebElement submitNewTodoButton;

    @Step
    public NewTodoPage  load()
    {
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ "/todo/new");

        return this;
    }

    @Step
    public NewTodoPage addNewTodoName(String name)
    {
        addTodoName.sendKeys(name);
        return this;
    }

    @Step
    public TodoPage submitNewTodoButton()
    {
        submitNewTodoButton.click();
        return new TodoPage(driver);
    }






}
