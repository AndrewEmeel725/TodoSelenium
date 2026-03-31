package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TaskApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.util.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Feature("Todo")

public class TodoTest extends BaseTest {


    @Story("Add Todo")
    @Test(description = "Should be able to add Todo Correctly")
    public void shouldBeAbleToAddTodo ()
    {
        RegisterApi registerApi= new RegisterApi();
        registerApi.register();




        NewTodoPage newTodoPage = new NewTodoPage(getDriver());
        newTodoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());

       String todoName= newTodoPage.load()
                .addNewTodoName("learn selenium").submitNewTodoButton().getTodoText();


        Assert.assertEquals( todoName ,"learn selenium");








    }


    @Story("Delete Todo")
    @Test(description = "Should be able to delete Todo Correctly")
    public void shouldBeAbleToDeleteTodo ()
    {
        RegisterApi registerApi= new RegisterApi();
        registerApi.register();

        TaskApi taskApi = new TaskApi();
        taskApi.addTask(registerApi.getToken());



        TodoPage todoPage= new TodoPage(getDriver());
        todoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());


      boolean isNotTodoMessageDisplayed = todoPage.load().clickOnDeleteButton().noTodosIsDisplayed();
      Assert.assertTrue(isNotTodoMessageDisplayed);

    }

}
