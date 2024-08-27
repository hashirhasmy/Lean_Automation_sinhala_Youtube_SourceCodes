package Screenshots;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class TakeScreenshotsCommonMethods {

    public static void takeWebPageScreenShot(WebDriver driver, String filename) throws IOException {
        // Create a date formatter
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss");
        // Get the current date and time
        Date date = new Date();
        // Format the date and time
        String timestamp = formatter.format(date);

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(System.getProperty("user.dir") + "\\ScreenShot\\" + filename + "_" + timestamp + ".png");
        FileHandler.copy(sourceFile, destinationFile);
    }

    public static void takeEntireScreenScreenshot(String filename) throws AWTException, IOException {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new Date());
        Robot robot = new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(screenSize);
        BufferedImage sourceFile = robot.createScreenCapture(rectangle);

        File destinationFile = new File(System.getProperty("user.dir") + "\\ScreenShot\\" + filename + "_" + timestamp + ".png");
        ImageIO.write(sourceFile,"png",destinationFile);
    }

    public static void screenShotOutputByteArray(WebDriver driver, String filename) throws FileNotFoundException {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        byte[] sourceFileByteArray = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        File destinationFile = new File(System.getProperty("user.dir") + "\\ScreenShot\\" + filename + "_" + timestamp + ".png");
        FileOutputStream fos = new FileOutputStream(destinationFile);
        try {
            fos.write(sourceFileByteArray);
            fos.close();
        } catch (Exception e) {
            System.out.println("I am inside screenShotOutputByteArray catch block");
            e.printStackTrace();
        }
    }

    public static void screenShotOutputBase64(WebDriver driver, String filename) throws FileNotFoundException {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        String sourceFileBase64Code = takesScreenshot.getScreenshotAs(OutputType.BASE64);
        byte[] sourceFileByteArray= Base64.getDecoder().decode(sourceFileBase64Code);
        File destinationFile = new File(System.getProperty("user.dir") + "\\ScreenShot\\" + filename + "_" + timestamp + ".png");
        FileOutputStream fos = new FileOutputStream(destinationFile);
        try {
            fos.write(sourceFileByteArray);
            fos.close();
        } catch (Exception e) {
            System.out.println("I am inside screenShotOutputBase64 catch block");
            e.printStackTrace();
        }
    }

}
