package testNG.listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class ListenersTest {

    @Test
    public void test1(){
        System.out.println("I am inside testMethod1");
    }

    @Test
    public void test2(){
        System.out.println("I am inside testMethod2");
        Assert.assertTrue(false);
    }

    @Test(timeOut = 1000)
    public void test3() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("I am inside testMethod3");
    }

    @Test(dependsOnMethods = "test3")
    public void test4(){
        System.out.println("I am inside testMethod4");
    }
}
