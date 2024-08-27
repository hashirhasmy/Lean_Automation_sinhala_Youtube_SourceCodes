package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.center;
import static org.apache.commons.lang3.StringUtils.rightPad;

public class WebTableExampleAdvanced_1 {

    WebDriver driver;

    @BeforeMethod
    public void openTablePage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }


    @Test()
    public void validateBookTableFirstPageSecondColumnUsingList(){
        int tableRowCount=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        List<String> actualdata = new ArrayList<>();
        List<String> expecteddata = new ArrayList<>();

        for (int k=2; k<=tableRowCount; k++){
            String dynamicXpath = String.format("//table[@name='BookTable']//tr[%s]/td[2]",k);
            String name = driver.findElement(By.xpath(dynamicXpath)).getText();
            actualdata.add(name);
        }

        String[] ExpectedValues =  {"Amit","Mukesh","Animesh","Mukesh","Amod","Amit"};
        for (int g=0; g<ExpectedValues.length; g++){
            expecteddata.add(ExpectedValues[g]);
        }

        validateAndLog(expecteddata,actualdata,"Web Table");

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    public static void validateAndLog(String expectedLineItemsMap, String actualLineItemsTb, String tableName) {

        System.out.println("");
        System.out.println("");
        System.out.println(center("", 120, "_"));
        System.out.println(center(tableName,120, " "));

        System.out.println(center("", 120, "_"));
        System.out.println(center("Column Header", 40, " ") + "|" + center("Actual Value", 40, " ") + "|" +
                center("Expected Value", 40, " "));
        System.out.println(center("", 120, "_"));

        String actualValue = actualLineItemsTb;
        String expectedValue = expectedLineItemsMap;

        System.out.println(rightPad("		" + tableName, 40, " ") + rightPad("		" + actualValue, 40, " ") +
                rightPad("		" + expectedValue, 40, " "));

        try{
            Assert.assertEquals(actualValue.trim().toLowerCase(),expectedValue.toLowerCase(),actualLineItemsTb + " should be " + expectedValue);
        }catch(AssertionError e){
            System.out.println("Print i wanted message : " +e.getMessage());
        }
        System.out.println(center("End Log", 120, "-"));
        System.out.println("");
        System.out.println("");

    }

    public static void validateAndLog(Map<String, String> expectedLineItemsMap, Map<String, String> actualLineItemsTb, String tableName) {
        Set<String> expectedKeySet = expectedLineItemsMap.keySet();
        List<String> arrayList = new ArrayList<>(expectedKeySet);

        System.out.println("");
        System.out.println("");
        System.out.println(center("", 120, "_"));
        System.out.println(center(tableName,120, " "));

        System.out.println(center("", 120, "_"));
        System.out.println(center("Column Header", 40, " ") + "|" + center("Actual Value", 40, " ") + "|" +
                center("Expected Value", 40, " "));
        System.out.println(center("", 120, "_"));


        for (int i = 0; i < expectedLineItemsMap.size(); i++) {
            String key = arrayList.get(i);
            String actualValue = validateNull(actualLineItemsTb.get(key));
            String expectedValue = validateNull(expectedLineItemsMap.get(key));

            System.out.println(rightPad("		" + key, 40, " ") + rightPad("		" + actualValue, 40, " ") +
                    rightPad("		" + expectedValue, 40, " "));
            try {
                Assert.assertTrue(actualValue.trim().equalsIgnoreCase(expectedValue),key + " should be " + expectedValue);
            } catch (AssertionError e) {
                System.out.println("Error is : " + e.getMessage());
                throw e;
            }

        }

        System.out.println(center("End Log", 120, "-"));
        System.out.println("");
        System.out.println("");
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
            String actualValue = validateNull(actualValues.get(i));
            String expectedValue = validateNull(expectedValues.get(i));

            System.out.println(rightPad(Integer.toString(i + 1), 40, " ") +
                    rightPad(actualValue, 40, " ") +
                    rightPad(expectedValue, 40, " "));

            try {
                Assert.assertTrue(actualValue.trim().equalsIgnoreCase(expectedValue),"Index " + (i + 1) + " should be " + expectedValue);
            } catch (AssertionError e) {
                System.out.println("Error is: " + e.getMessage());
                throw e;
            }
        }

        System.out.println(center("End Log", 120, "-"));
        System.out.println("");
        System.out.println("");
    }

    public static String validateNull(String inputData) {
        String returnData = "N//A";
        if (inputData != null) {
            returnData = inputData;
        }
        return returnData;
    }
}
