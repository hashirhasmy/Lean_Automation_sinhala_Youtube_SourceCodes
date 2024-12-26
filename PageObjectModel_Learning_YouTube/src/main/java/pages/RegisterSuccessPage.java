package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterSuccessPage {

    WebDriver driver;

    public RegisterSuccessPage(WebDriver driver){
        this.driver = driver;
    }


    By successText_loc = By.xpath("//b[contains(text(),'Dear')]");

    public String registerSuccessText(){
        String successText = driver.findElement(successText_loc).getText();
        return successText;
    }




}
