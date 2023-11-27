package org.example;

import org.testng.Assert;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestRunner {

    public String run(String data) {
        String[] params = data.split(" ");
        String className = params[0];
        String methodName = params[1];
        String fileFolderPath = "test/SeleniumAWS/src/test/resources";
        String fileName = String.format("%s.%s.xml", className, methodName);
        String fileContent = Settings.TEST_NG_METHOD_FILE_TEMPLATE;
        fileContent = fileContent.replace(Settings.CLASS_NAME_PLACEHOLDER, className);
        fileContent = fileContent.replace(Settings.METHOD_NAME_PLACEHOLDER, methodName);

        String command = "sh clone-project.sh";
        System.out.println(command);

        FileManager.createFile(fileFolderPath, fileName, fileContent);

        command = "sh run-test.sh";
        System.out.println(command);

        String output = CommandLineExecutor.runCommandLine(command);
        System.out.println("Output:\n" + output);

        if (!output.contains("BUILD SUCCESS")) {
            Assert.fail(output);
        }

        return output;
    }
}
