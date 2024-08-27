import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class DownloadUploadFileExample {
    WebDriver driver;

    @BeforeMethod
    public void openFileTestsPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void fileDownloadTest() throws InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");
        Thread.sleep(3000);
        WebElement downloadBtn =driver.findElement(By.id("j_idt93:j_idt95"));
        downloadBtn.click();
        Thread.sleep(3000);

        File file = new File("C:\\Users\\hhashmi\\Downloads");
        File[] totalFiles = file.listFiles();

        for (File findFile:totalFiles) {
            if (findFile.getName().equals("TestLeaf Logo.png")){
                System.out.println("File is downloaded");
                break;
            }
        }
    }

    @Test
    public void fileUploadTest() throws AWTException, InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");

        //1st way - Using Robot class
//        WebElement uploadBtn = driver.findElement(By.id("j_idt88:j_idt89"));
//        uploadBtn.click();
//
//        //windows control begin hetre
//
//        String data = "C:\\Users\\hhashmi\\Downloads\\download.jpg";
//        StringSelection selection = new StringSelection(data);
//        //Coping the path to clipboard
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
//
//        Thread.sleep(4000);
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//
//        Thread.sleep(3000);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);


        //2nd way - Using Send Keys (Applicable only element type is file )

        String data = "C:\\Users\\hhashmi\\Downloads\\download.jpg";
        WebElement uploaduisngSenKeys =driver.findElement(By.id("j_idt88:j_idt89_input"));
        uploaduisngSenKeys.sendKeys(data);



    }
}
