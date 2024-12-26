package testCases;

import functions.NewtoursCommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class TC001_RegisterUserTestUpdated {

    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/newtours/index.php");
    }

    @Test
    public void TC001(){

        HomePageUpdated homePage = new HomePageUpdated(driver);

        String actualText =homePage.selectRegisterMenu()
                            .setFirstName("Mohamed")
                            .setLastName("Hashir")
                            .setEmail("test@gmail.com")
                            .selectCountry()
                            .setUserName("Mhashir")
                            .setPassword("test123")
                            .setConfirmPassword("test123")
                            .submit()
                            .registerSuccessText();

        Assert.assertTrue(actualText.contains("Dear"),"Registration Attempt failed");

    }





    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }



    //    public void registerUser(){
//        HomePageUpdated homePage = new HomePageUpdated(driver);
//        homePage.registerBtn_ele.click();
//
//        RegisterPageUpdated registerPage = new RegisterPageUpdated(driver);
//        registerPage.setFirstName("Mohamed");
//        registerPage.setLastName("Hashir");
//        registerPage.setEmail("test@gmail.com");
//        registerPage.selectCountry();
//        registerPage.setUserName("Mhashir");
//        registerPage.setPassword("test123");
//        registerPage.setConfirmPassword("test123");
//        registerPage.submit();
//    }
//
//
//    public void verifyRegistrationSuccess(){
//        RegisterSuccessPageUpdated registerSuccessPage = new RegisterSuccessPageUpdated(driver);
//        String actualText = registerSuccessPage.registerSuccessText();
//        Assert.assertTrue(actualText.contains("Dear"),"Registration Attempt failed");
//    }



}
