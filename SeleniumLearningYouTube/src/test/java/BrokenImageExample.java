import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class BrokenImageExample {
    WebDriver driver;

    @BeforeMethod
    public void openImagePage() {
        ChromeOptions chromeOptions = new ChromeOptions();
        File file = new File("C:\\Users\\hhashmi\\Downloads\\SelectorsHub-Chrome-Web-Store.crx");
        chromeOptions.addExtensions(file);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @Test
    public void findBrokenImageTest(){
        driver.get("https://the-internet.herokuapp.com/broken_images");

        List<WebElement> images =  driver.findElements(By.xpath("//div[@class='example']/img"));

        // "naturalWidth" = '0'

        int i = 1;
        for (WebElement image:images) {
            if (image.getAttribute("naturalWidth").equals("0")){
                System.out.println("Image " + i + " is Broken");
            } else{
                System.out.println("Image " + i + " is not broken");
            }
            i++;
        }

    }

    @Test
    public void findBrokenImageTestTwo(){
        driver.get("https://demoqa.com/broken");
        WebElement brokenImage = driver.findElement(By.xpath("//*[text()='Valid image']/parent::div/img[2]"));
        if (brokenImage.getAttribute("naturalWidth").equals("0")){
            System.out.println("image is broken");
        } else {
            System.out.println("image not broken");
        }
    }


}
