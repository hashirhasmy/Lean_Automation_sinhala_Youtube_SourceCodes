package testNG;

import org.testng.annotations.Test;

public class TestNGAnnotation01 {

    public static void main(String[] args) {
        System.out.println("This is not a TestNG test 01");
        TestNGAnnotation01 testNGAnnotation01 = new TestNGAnnotation01();
        testNGAnnotation01.notATestNGMethod();
    }

    public void notATestNGMethod(){
        System.out.println("This is not a TestNG test 02");
    }

    @Test
    public void test(){
        System.out.println("Test 01");
    }

}
