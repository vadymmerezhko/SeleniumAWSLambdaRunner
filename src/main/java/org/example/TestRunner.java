package org.example;

import org.testng.Assert;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestRunner {

    public String run(String data) {
        String[] params = data.split(" ");
        String projectFolderPath = params[0];
        String className = params[1];
        String methodName = params[2];
        String fileFolderPath = String.format("%s/src/test/resources", projectFolderPath);
        String fileName = String.format("%s.%s.xml", className, methodName);
        String fileContent = Settings.TEST_NG_METHOD_FILE_TEMPLATE;
        fileContent = fileContent.replace(Settings.CLASS_NAME_PLACEHOLDER, className);
        fileContent = fileContent.replace(Settings.METHOD_NAME_PLACEHOLDER, methodName);

        FileManager.createFile(fileFolderPath, fileName, fileContent);

        //System.setProperty("user.dir", projectFolderPath);

        String command = String.format(
                //"cmd /c && " +
               //"sh " +
                //String.format("cd \"%s\"\n", projectFolderPath) +
                //"mvn test \"-DtestSuite=%s/%s\" \"-DthreadCount=1\" \"-Dlambda=no\"\n",
                "sh run-test.sh",
                fileFolderPath, fileName);

        System.out.println(command);

        String output = CommandLineExecutor.runCommandLine(command);

        System.out.println("Output:\n" + output);

        if (!output.contains("BUILD SUCCESS")) {
            Assert.fail(output);
        }

        return output;
    }
}
