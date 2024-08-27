import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.List;

public class ActionKeyboardExample {

    WebDriver driver;

    @BeforeMethod
    public void keyboardOperationsTestsBrowserOpen(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void KeyBordActionsTest1() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement googleSerchTextBox = driver.findElement(By.name("q"));
//        googleSerchTextBox.sendKeys("welcome");
//
        Actions actions = new Actions(driver);
//        //Select the Text
//        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
//
//        Thread.sleep(5000);
//
//        actions.keyDown(Keys.SHIFT)
//                .sendKeys("writing capital sentence").perform();
//        Thread.sleep(5000);
//
//
//        actions.keyUp(Keys.SHIFT)
//                .keyDown(Keys.CONTROL)
//                .sendKeys("a")
//                .keyUp(Keys.CONTROL)
//                .keyDown(Keys.CONTROL)
//                .sendKeys("x")
//                .build().perform();

        //To write in capital in a text box

        actions.keyDown(googleSerchTextBox, Keys.SHIFT)
                .sendKeys("learn with hashir")
                .perform();
    }




    @Test
    public void KeyBordActionsTest2() throws InterruptedException {
        driver.get("https://www.leafground.com/list.xhtml");
        Thread.sleep(4000);

        List<WebElement> selectable =  driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        int size = selectable.size();
        System.out.println("Li count is :" + size);


        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(selectable.get(0))
                .click(selectable.get(1))
                .click(selectable.get(2))
                .perform();


    }

}
