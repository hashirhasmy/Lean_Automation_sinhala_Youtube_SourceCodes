package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityTest01 {

    @Test(priority = 0)
    public void testLogin(){
        System.out.println("Login");
        Assert.assertEquals("1","1");
    }
    @Test(priority = 1)
    public void testCreate(){
        System.out.println("Create");
    }
    @Test(priority = 2, enabled = false)
    public void testEdit(){
        System.out.println("Edit");
    }
    @Test(priority = 3)
    public void testDelete(){
        System.out.println("Delete");
    }
    @Test(priority = 4)
    public void testLogout(){
        System.out.println("Logout");
    }


}
