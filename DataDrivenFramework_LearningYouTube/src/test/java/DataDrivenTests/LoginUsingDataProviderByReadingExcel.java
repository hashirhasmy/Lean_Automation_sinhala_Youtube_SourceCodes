package DataDrivenTests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class LoginUsingDataProviderByReadingExcel {




//    public void readExcelData() throws IOException {
//
//        // Path>     D:\Previous_Pc_Codes\DataDrivenFramework_LearningYouTube\testData
//        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testData\\credentials1.xlsx");
//        XSSFWorkbook workbook = new XSSFWorkbook(file);
//        XSSFSheet sheet = workbook.getSheet("Sheet1");    //workbook.getSheetAt(0);
//        int totalRows = sheet.getLastRowNum();
//        int totalColumns = sheet.getRow(0).getLastCellNum();
//        System.out.println("Total Rows count : " + totalRows);          //4  (actually have 5)
//        System.out.println("Total Columns count : " + totalColumns);    //3
//
//        for (int r=0; r<=totalRows; r++){
//
//            XSSFRow currentRow =sheet.getRow(r);
//
//            for (int c=0; c<totalColumns; c++){
//                XSSFCell currentCell =currentRow.getCell(c);
//                String cellValue = currentCell.toString();
//                System.out.print(cellValue + "\t\t");
//            }
//
//            System.out.println();
//        }
//    }



    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @DataProvider(name = "loginData")
    public Object[][] getExcelData() throws IOException {

        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testData\\credentials1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");    //workbook.getSheetAt(0);
        int totalRows = sheet.getLastRowNum();
        int totalColumns = sheet.getRow(0).getLastCellNum();
        System.out.println("Total Rows count : " + totalRows);          //4  (actually have 5)
        System.out.println("Total Columns count : " + totalColumns);    //3


        String[][] testData = new String[totalRows][totalColumns];



        for (int r=1; r<=totalRows; r++){
            for (int c=0; c<totalColumns; c++){
                testData[r-1][c] =  sheet.getRow(r).getCell(c).toString();
            }
        }


        workbook.close();
        file.close();

        return testData;

    }


//    @DataProvider(name = "loginData")
//    public Object[][] loginDataProvider(){
//        String[][] data = {
//                {"Admin", "admin123", "valid"},
//                {"dummyAdmin", "dummyPass", "invalid"},
//                {"Admin","dummyPass","invalid"},
//                {"dummyAdmin","admin123","invalid"}
//        };
//        return data;
//    }




    @Test(dataProvider = "loginData")
    public void loginTestScenario(String uName, String pass, String expValidation) throws InterruptedException {
        WebElement userName =driver.findElement(By.xpath("//input[@placeholder='Username']"));
        userName.sendKeys(uName);
        WebElement password =driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys(pass);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(3000);

        boolean urlVerification = driver.getCurrentUrl().contains("dashboard");


        if (expValidation.equals("valid")){
            Assert.assertTrue(urlVerification,"Expecting login success but not navigated to dashboard");
        }else{
            Assert.assertFalse(urlVerification,"Expecting login failed but navigated to dashboard");
        }

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }



}
