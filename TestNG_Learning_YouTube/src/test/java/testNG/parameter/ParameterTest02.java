package testNG.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest02 {

    @Test
    @Parameters({"val1","val2"})
    public void Diff (int v1,int v2) {
        int finaldiff = v1 - v2;
        System.out.println("The final difference of the given values is " + finaldiff);
    }
}
