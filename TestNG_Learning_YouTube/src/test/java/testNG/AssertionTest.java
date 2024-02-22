package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTest {

    SoftAssert softAssert = new SoftAssert();
    String actualValue = "Hashir";

    @Test(priority = 0)
    public void valuesEqualCheck(){
        String expectedValue = "Hashir";
        System.out.println("Prior to valuesEqualCheck assertion");
        softAssert.assertEquals(actualValue,expectedValue,"Values miss matched");
        System.out.println("After valuesEqualCheck assertion");
        softAssert.assertAll();

    }

    @Test(priority = 1)
    public void valuesNotEqualCheck(){
        String expectedValue = "Learn Well";
        System.out.println("Prior to valuesNotEqualCheck assertion");
        softAssert.assertNotEquals(actualValue,expectedValue,"values matched");
        System.out.println("After to valuesNotEqualCheck assertion");

    }

    @Test(priority = 2)
    public void trueConditionCheck(){
        System.out.println("Prior to trueConditionCheck assertion");
        softAssert.assertTrue(actualValue.startsWith("H"),"Condition Return a False");
        System.out.println("After to trueConditionCheck assertion");

    }

    @Test(priority = 3)
    public void falseConditionCheck(){
        System.out.println("Prior to falseConditionCheck assertion");
        softAssert.assertFalse(actualValue.isBlank(),"Condition Return a True");
        System.out.println("After to falseConditionCheck assertion");

    }
}
