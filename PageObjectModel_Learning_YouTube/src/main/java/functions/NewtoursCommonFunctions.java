package functions;

import org.openqa.selenium.WebDriver;
import pages.HomePageUpdated;
import pages.RegisterPageUpdated;
import pages.RegisterSuccessPageUpdated;

public class NewtoursCommonFunctions {

    WebDriver driver;
    public NewtoursCommonFunctions(WebDriver driver){
        this.driver = driver;
    }

    public String registerUser(String fName, String lName, String email, String uName, String pass, String conformPass){
        HomePageUpdated homePage = new HomePageUpdated(driver);
        homePage.registerBtn_ele.click();

        RegisterPageUpdated registerPage = new RegisterPageUpdated(driver);
        registerPage.setFirstName(fName);
        registerPage.setLastName(lName);
        registerPage.setEmail(email);
        registerPage.selectCountry();
        registerPage.setUserName(uName);
        registerPage.setPassword(pass);
        registerPage.setConfirmPassword(conformPass);
        registerPage.submit();

        RegisterSuccessPageUpdated registerSuccessPage =new RegisterSuccessPageUpdated(driver);
        String successText = registerSuccessPage.registerSuccessText();
        return successText;
    }




}
