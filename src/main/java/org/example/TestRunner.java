package org.example;

import org.eclipse.jgit.api.Git;
import org.testng.Assert;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestRunner {

    public String run(String data) {
        String[] params = data.split(" ");
        String className = params[0];
        String methodName = params[1];
        String fileFolderPath = "src/test/resources";
        String fileName = String.format("%s.%s.xml", className, methodName);
        String fileContent = Settings.TEST_NG_METHOD_FILE_TEMPLATE;
        fileContent = fileContent.replace(Settings.CLASS_NAME_PLACEHOLDER, className);
        fileContent = fileContent.replace(Settings.METHOD_NAME_PLACEHOLDER, methodName);

/*        String command = "sh clone-project.sh";
        //String command = "cmd clone-project.bat";
        System.out.println(command);

        String output = CommandLineExecutor.runCommandLine(command);
        System.out.println("Output 1:\n" + output);*/

        try {
            Git.cloneRepository()
                    .setURI("https://github.com/vadymmerezhko/SeleniumAWS.git")
                    .setDirectory(new File("."))
                    .call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

/*        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current absolute path is: " + s);*/

        FileManager.createFile(fileFolderPath, fileName, fileContent);

        String command = String.format("sh run-test.sh %s", fileName);
        //command = "cmd run-test.bat";
        System.out.println(command);

        String output = CommandLineExecutor.runCommandLine(command);
        System.out.println("Output 2:\n" + output);

        if (!output.contains("BUILD SUCCESS")) {
            Assert.fail(output);
        }

        return output;
    }
}
