package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.User;
import com.qacart.todo.util.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {


    private List<Cookie> restasssuredCookies;
    private String accessToken;
    private  String userID;
    private  String  firstName;

    public String getToken ()
    {
       return   this.accessToken;
    }

    public String getUerID ()
    {
        return   this.userID;
    }

    public String getFirstName ()
    {
        return   this.firstName;
    }
    public List<Cookie> getCookies()
    {
        return  this.restasssuredCookies;
    }


    public void register()
    {

        User user = UserUtils.generateRandomUser();


        Response response=
                given()
                        .baseUri("https://qacart-todo.herokuapp.com")
                        .header("Content-Type","application/json")
                        .body(user)
                        .log().all()
                        .when()
                        .post(EndPoint.API_REGISTER_ENDPOINT)
                        .then()
                        .log().all()
                        .extract().response();

        if(response.statusCode() != 201) {
            throw  new RuntimeException("Error in Status Code");
        }


        restasssuredCookies= response.detailedCookies().asList();  // Cookies for rest assured
        accessToken = response.path("access_token");
        userID= response.path("userID");
        firstName= response.path("firstName");

        System.out.println(response.prettyPrint());

    }

}
