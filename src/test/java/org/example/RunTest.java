package org.example;

import org.testng.annotations.Test;

public class RunTest {

    @Test
    public void RunLambdaTest() {
        TestRunner runner = new TestRunner();
        runner.run("./ org.example.Selenium1Test signUp1");
    }
}
