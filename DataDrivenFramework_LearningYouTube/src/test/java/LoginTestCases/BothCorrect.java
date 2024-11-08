package LoginTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class BothCorrect {

    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }


    @Test
    @Parameters({"username","password"})
    public void loginWithBothCorrect(String uName, String pass){
        WebElement userName =driver.findElement(By.xpath("//input[@placeholder='Username']"));
        userName.sendKeys(uName);

        WebElement password =driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys(pass);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
