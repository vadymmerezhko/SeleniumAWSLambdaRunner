package org.example;

import org.testng.annotations.Test;

public class RunTest {

    @Test
    public void RunLambdaTest() {
        TestRunner.run(
                //"C:\\Users\\vadym\\IdeaProjects\\GitHub\\SeleniumAWS",
                "/home/ec2-user/test/SeleniumAWS",
                "org.example.Selenium1Test",
                "signUp1");
    }
}
