import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample {


    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }

    @Test
    public void LinkTests(){
        //01) Take me to dashboard
        WebElement homeLink =  driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();

        //02) Find my destination
        WebElement wheretoGo = driver.findElement(By.partialLinkText("Find the URL"));
        String path = wheretoGo.getAttribute("href");
        System.out.println("This link is going to : " + path);

        //03) Am I broken link?
        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();

        String title = driver.getTitle();
        if (title.contains("404")){
            System.out.println("The link is broken");
        } else{
            System.out.println("Not broken");
        }
        driver.navigate().back();

        //04) Duplicate Link
        WebElement homeLink1 =  driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();

        //05) Count page Links
        List<WebElement> countfullpageLinks =  driver.findElements(By.tagName("a"));
        int pageLinkCount = countfullpageLinks.size();
        System.out.println("Count of full page links : " + pageLinkCount);

        //06) count layout links
        WebElement layoutElemnt = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countOfLayoutLinks = layoutElemnt.findElements(By.tagName("a"));
        System.out.println("Count of layout links : " + countOfLayoutLinks.size());
    }

}
