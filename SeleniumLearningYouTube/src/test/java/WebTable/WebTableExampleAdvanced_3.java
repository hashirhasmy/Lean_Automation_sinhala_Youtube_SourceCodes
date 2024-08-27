package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.center;
import static org.apache.commons.lang3.StringUtils.rightPad;

public class WebTableExampleAdvanced_3 {

    WebDriver driver;

    @BeforeMethod
    public void openTablePage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }


    @Test
    public void validateBookTblsecondColumnFirstPageUsingMap(){
        int tableRowCount=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();

        LinkedHashMap<String,String> actualdata = new LinkedHashMap<>();
        LinkedHashMap<String,String> expecteddata = new LinkedHashMap<>();

        for (int k=1; k<tableRowCount; k++){
            String dynamicXpath = String.format("//table[@name='BookTable']//tr[%s]/td[2]",k+1);
            String name = driver.findElement(By.xpath(dynamicXpath)).getText();

            String TableId = "Name" + k;
            actualdata.put(TableId,name);
        }

        String[] ExpectedValues =  {"Amit","Mukesh","Animesh","Mukesh","Amod","Amit"};
        for (int g=1; g<=ExpectedValues.length; g++){
            expecteddata.put("Name" + g, ExpectedValues[g-1]);
        }


//        //1st way
//        validateAndLog(expecteddata,actualdata,"Book Table");


        //2nd way
        LinkedHashMap<String, String> validationStatusRulesMap = getValidationStatus(actualdata,expecteddata);
        String testScriptStatusRulesMap =dataMapsValidationstring("Name",actualdata,expecteddata,validationStatusRulesMap);
        Assert.assertEquals(testScriptStatusRulesMap,"PASS");

    }


    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }


    //1st way method
    public static void validateAndLog(LinkedHashMap<String, String> expectedValues, LinkedHashMap<String, String> actualValues, String tableName) {
        // Table column width
        int columnWidth = 20;

        // Print the table header
        System.out.println("Validation Results for " + tableName);
        System.out.println(center(tableName,100, " "));
        System.out.println(rightPad("=====",170, '='));
        System.out.println(
                center("Key", columnWidth) +
                        center("Expected Value", columnWidth) +
                        center("Actual Value", columnWidth) +
                        center("Status", columnWidth)
        );


        // Iterate through the expected values map and compare with actual values
        expectedValues.forEach((key, expectedValue) -> {
            String actualValue = actualValues.get(key);
            String status = expectedValue.equals(actualValue) ? "PASS" : "FAIL";

            // Log the result in table format
            System.out.println(
                    center(key, columnWidth) +
                            center(expectedValue, columnWidth) +
                            center(actualValue, columnWidth) +
                            center(status, columnWidth)
            );

            // Perform assertion
            Assert.assertEquals(actualValue, expectedValue, "Validation failed for key: " + key);
        });
    }



    //2nd way methods
    public static String dataValidationstring(String actualValue, String expectedValue) {

        String status = "FAIL";
        if (actualValue.equals(expectedValue)) {
            status = "PASS";
        }
        return status;
    }

    public static LinkedHashMap<String, String> getValidationStatus(LinkedHashMap <String, String> expectedValuesMap, LinkedHashMap <String, String> actualValuesMap) {
        Set<String> dtkeys = expectedValuesMap.keySet();
        ArrayList<String> covertedArraydtKey = new ArrayList<>(dtkeys);

        LinkedHashMap<String, String> validataionStatus = new LinkedHashMap<>();
        for (int i = 0; i < expectedValuesMap.size(); i++) {
            String key = covertedArraydtKey.get(i);
            String actualConfigStatus = validateNull(actualValuesMap.get(key));
            String expectedConfigStatus = validateNull(expectedValuesMap.get(key));
            validataionStatus.put(key, dataValidationstring(expectedConfigStatus, actualConfigStatus));
        }

        return validataionStatus;
    }


    public static String dataMapsValidationstring(String type,LinkedHashMap<String, String> ActualData, LinkedHashMap<String, String> ExpectedData, LinkedHashMap<String, String> validationStatus) {
        Set<String> dtkeys = ExpectedData.keySet();
        ArrayList<String> covertedArraydtKey = new ArrayList<>(dtkeys);
        String testScriptStatus = "PASS";
        int validatedRecords = 0;


        System.out.println("          " + rightPad(type,50) + rightPad("Actual Data",30) + rightPad("Expected Data",30) +
                rightPad("Status",300));

        System.out.println(rightPad("=====",170, '='));
        for (int i = 0; i < ExpectedData.size(); i++) {
            String key = covertedArraydtKey.get(i).toString();
            String actualDataStatus = ActualData.get(key);
            String expectedDataStatus = ExpectedData.get(key);
            String status = validationStatus.get(key);
            System.out.println("          " + rightPad(key,50) + rightPad(actualDataStatus.toString(),30) + rightPad(expectedDataStatus.toString(),30) +
                    rightPad(status,30));
            if (status == "FAIL") {
                testScriptStatus = "FAIL";
            }

            validatedRecords++;
        }
        System.out.println(rightPad("=====",170, "="));
        System.out.println("No of Items in ExpectedData : " + ExpectedData.size());
        System.out.println("No of Items in ActualData : " + ActualData.size());
        System.out.println("No of Items Validated : " + validatedRecords);

        return testScriptStatus;
    }

    public static String validateNull(String inputData) {
        String returnData = "N//A";
        if (inputData != null) {
            returnData = inputData;
        }
        return returnData;
    }


}
