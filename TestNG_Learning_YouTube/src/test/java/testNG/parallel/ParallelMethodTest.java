package testNG.parallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParallelMethodTest {
    @Test(priority = 0)
    public void openGoogle(){
        System.out.println("Open google");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.quit();
    }

    @Test(priority = 1)
    public void openBing(){
        System.out.println("Open Bing");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bing.com/");
        driver.quit();
    }
}
