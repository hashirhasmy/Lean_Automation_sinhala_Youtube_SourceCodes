package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableExample {

    WebDriver driver;

    @BeforeMethod
    public void openTablePage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @Test()
    public void webTableTest() throws InterruptedException {
        //1) How many rows in the Table
        int rowCount = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
        System.out.println("Rows count is :" + rowCount);

        //2) How many columns in the table
        int columnCount = driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th")).size();
        System.out.println("Column count is :" + columnCount);

        //3) Retrieve the specific row/column data

        String value=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[3]/td[3]")).getText();
        System.out.println("Specified row/column data : " + value);

        //4) Retrieve all the data from table

        for (int i = 1; i<=rowCount; i++){   //Rows
          for (int j=1; j<columnCount; j++){    //Columns
              String tblData = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
              System.out.print(tblData + "  ");
          }
            System.out.println();
        }


        //5) print ID and Name only
            //5.1) Find the product Price, which Name related to Product 3
        for (int i=1; i<=rowCount; i++){
            String tblId = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[1]")).getText();
            String tblProductName = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[2]")).getText();
            System.out.println("Tbl id : " + tblId + "\t\t"  + " product name is : " + tblProductName);

            if(tblProductName.equals("Product 3")){
                String productPrice = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[3]")).getText();
                System.out.println(tblProductName + "Relevent product price is : " + productPrice);
                break;
            }
        }

        //6) Select all the checkBoxes

        int pageCount = driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
        List<WebElement> pages =  driver.findElements(By.xpath("//ul[@id='pagination']/li"));

        for (int k=0; k<pageCount; k++){
            pages.get(k).click();
            Thread.sleep(1000);
            for(int i=1; i<=rowCount; i++){
                boolean atb=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[4]/input")).isSelected();
                if (!atb){
                    driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[4]/input")).click();
                    Thread.sleep(300);
                }
            }
        }

        //7) Select one checkbox
        int tblRow= 1;
        driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+tblRow+"]/td[4]/input")).click();

    }
}
