package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.center;
import static org.apache.commons.lang3.StringUtils.rightPad;

public class WebTableExampleAdvanced_2 {

    WebDriver driver;

    @BeforeMethod
    public void openTablePage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }


    @Test
    public void getProductTblAllCheckboxesCountInAllPages() throws InterruptedException {

        //1) getAllCheckboxesCount

        int line = 1;
        int tblPage = 1;
        List<String> slectedList = new ArrayList();
        List<WebElement> pages = driver.findElements(By.xpath("//ul[@id='pagination']/li"));

        for (WebElement page:pages){
            Thread.sleep(5000);
            page.click();
            List<WebElement> tableLines =driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));
            int x = 1;

            for (WebElement tblLine:tableLines) {
                boolean actualAttribute=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+x+"]/td[4]/input")).isDisplayed();
                if (actualAttribute) {
                    slectedList.add(String.valueOf(line));
                    System.out.println(line + ")************************Page " + tblPage + " Line " + x +
                            " Checkbox Available************************");
                } else {
                    System.out.println(line + ")************************Page " + tblPage + " Line " + x +
                            " Checkbox unavailable************************");
                }
                x++;
                line++;
            }
            tblPage++;
        }
        System.out.println("CheckBox count is : " + slectedList.size());
    }

    @Test
    public void validateProductTableSecondColumnInAllPagesUsingList() throws InterruptedException {
        List<String> actualdata = new ArrayList<>();
        List<String> expecteddata = new ArrayList<>();
        List<WebElement> pages = driver.findElements(By.xpath("//ul[@id='pagination']/li"));

        for (WebElement page:pages){
            Thread.sleep(5000);
            page.click();
            List<WebElement> tableLines =driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));
            int x = 1;
            for (WebElement tblLine:tableLines) {
                String tableLinedata =driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+x+"]/td[2]")).getText();
                actualdata.add(tableLinedata);
                x++;
            }
        }

        String[] ExpectedValues =  {"Product 1","Product 2","Product 3","Product 4","Product 5","Product 6","Product 7","Product 8","Product 9","Product 10",
                "Product 11","Product 12","Product 13","Product 14","Product 15","Product 16","Product 17","Product 18","Product 19","Product 20"};
        for (int g=0; g<ExpectedValues.length; g++){
            expecteddata.add(ExpectedValues[g]);
        }

        validateAndLog(expecteddata,actualdata,"Pagination Table");

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    public static void validateAndLog(List<String> expectedValues, List<String> actualValues, String tableName) {
        System.out.println("");
        System.out.println("");
        System.out.println(center("", 120, "_"));
        System.out.println(center(tableName, 120, " "));

        System.out.println(center("", 120, "_"));
        System.out.println(center("Index", 20, " ") + "|" + center("Actual Value", 50, " ") + "|" +
                center("Expected Value", 50, " "));
        System.out.println(center("", 120, "_"));

        int size = Math.min(expectedValues.size(), actualValues.size());

        for (int i = 0; i < size; i++) {
            String actualValue = actualValues.get(i);
            String expectedValue = expectedValues.get(i);

            System.out.println(rightPad(Integer.toString(i + 1), 40, " ") +
                    rightPad(actualValue, 40, " ") +
                    rightPad(expectedValue, 40, " "));

            try {
//                assertThat(actualValue.trim()).describedAs("Index " + (i + 1) + " should be " + expectedValue)
//                        .isEqualToIgnoringCase(expectedValue);
                Assert.assertTrue(actualValue.equalsIgnoreCase(expectedValue),"Index " + (i + 1) + " should be " + expectedValue);
            } catch (AssertionError e) {
                System.out.println("Error is: " + e.getMessage());
                throw e;
            }
        }

        System.out.println(center("End Log", 120, "-"));
        System.out.println("");
        System.out.println("");
    }

}
