package testNG;

import org.testng.annotations.Test;

public class GroupTest {

   // S= smoke      R = regression

    @Test(groups = {"S","R"})
    public void test01(){
        System.out.println("This is Smoke and Regression Test case");
    }
    @Test(groups = {"R"})
    public void test02(){
        System.out.println("This is Regression Test case");
    }
    @Test
    public void test03(){
        System.out.println("This is Not Smoke or Regression");
    }
    @Test(groups = {"S"})
    public void test04(){
        System.out.println("This is Smoke test case");
    }
    @Test(groups = {"S","R"})
    public void test05(){
        System.out.println("This is Smoke and Regression Test cas");
    }

}
