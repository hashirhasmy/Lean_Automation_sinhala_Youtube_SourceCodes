package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPageUpdated {

    WebDriver driver;

    public RegisterPageUpdated(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "firstName")
    WebElement firstName_ele;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastName_ele;

    @FindBy(xpath = "//input[@id='userName']")
    WebElement email_ele;

    @FindBy(xpath = "//select[@name='country']")
    WebElement countrySelect_ele;

    @FindBy(xpath = "//input[@id='email']")
    WebElement userName_ele;

    @FindBy(name = "password")
    WebElement password_ele;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    WebElement confirmPassword_ele;

    @FindBy(xpath = "//input[@name='submit']")
    WebElement submitBtn_ele;


    public RegisterPageUpdated setFirstName(String firstName){
        firstName_ele.sendKeys(firstName);
        return this;
    }

    public RegisterPageUpdated setLastName(String lastName){
        lastName_ele.sendKeys(lastName);
        return this;
    }

    public RegisterPageUpdated setEmail(String email){
        email_ele.sendKeys(email);
        return this;
    }

    public RegisterPageUpdated selectCountry(){
        Select dropDownCountry = new Select(countrySelect_ele);
        dropDownCountry.selectByIndex(2);
        return this;
    }

    public RegisterPageUpdated setUserName(String userName){
        userName_ele.sendKeys(userName);
        return this;
    }

    public RegisterPageUpdated setPassword(String password){
        password_ele.sendKeys(password);
        return this;
    }

    public RegisterPageUpdated setConfirmPassword(String confirmPassword){
        confirmPassword_ele.sendKeys(confirmPassword);
        return this;
    }

    public RegisterSuccessPageUpdated submit(){
        submitBtn_ele.click();
        return new RegisterSuccessPageUpdated(driver);
    }









}
