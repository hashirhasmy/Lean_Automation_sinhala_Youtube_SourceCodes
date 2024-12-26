package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterSuccessPageUpdated {

    WebDriver driver;

    public RegisterSuccessPageUpdated(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//b[contains(text(),'Dear')]")
    WebElement successText_ele;

    public String registerSuccessText(){
        String successText = successText_ele.getText();
        return successText;
    }




}
