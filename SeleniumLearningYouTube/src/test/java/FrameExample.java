import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameExample {

    //       **** frames = html page, inside main html page (need to swith one time)
    //                html
    //                    html


    //       ****  nested frames =   need to switch two times
    //                html
    //                    html
    //                        html




    WebDriver driver;

    @BeforeMethod
    public void frameTestsPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/frame.xhtml");
    }

    @Test
    public void frameTests(){
        //1) Click Me (Inside frame)

        driver.switchTo().frame(0);
        WebElement button1 =driver.findElement(By.xpath("//button[@id='Click']"));
        button1.click();

        String afterClickButtonText = button1.getText();
        System.out.println("After click Inside frame button Text : " + afterClickButtonText);

        //2) Click Me (Inside Nested frame)

        driver.switchTo().defaultContent();

        driver.switchTo().frame(2);  //inside into third frame
        driver.switchTo().frame("frame2"); //inside into third frame > Child frame

        WebElement button3 = driver.findElement(By.id("Click"));
        button3.click();

        String afterClickNestedFrameButtonText = button3.getText();
        System.out.println("After Click Inside Nested Frame Button Text : " + afterClickNestedFrameButtonText);

        //3) How many frames in this page

        driver.switchTo().defaultContent();

        List<WebElement> getIframeTagCount =  driver.findElements(By.tagName("iframe"));
        int size = getIframeTagCount.size();
        System.out.println("Iframe tag count : " + size);

        for (WebElement iframeElemnt :getIframeTagCount) {
            String frameSRCattributrValue=iframeElemnt.getAttribute("src");
            System.out.println("frame src attribute value : " + frameSRCattributrValue);
        }

    }
}
