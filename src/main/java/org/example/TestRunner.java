package org.example;

import org.apache.maven.shared.invoker.InvocationResult;
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
        String fileFolderPath = "/tmp/SeleniumAWS/src/test/resources";
        String fileName = "testngLambda.xml";
        String fileContent = Settings.TEST_NG_METHOD_FILE_TEMPLATE;
        fileContent = fileContent.replace(Settings.CLASS_NAME_PLACEHOLDER, className);
        fileContent = fileContent.replace(Settings.METHOD_NAME_PLACEHOLDER, methodName);

        String command;
        String output;

        GitManager.cloneRepository(
                "https://github.com/vadymmerezhko/SeleniumAWS.git",
                "/tmp/SeleniumAWS");
        System.out.println("Git repository is cloned");

        FileManager.createFile(fileFolderPath, fileName, fileContent);
        System.out.println("TestNG file is created");

        WebFileDownloadManager.download(
                "https://edgedl.me.gvt1.com/edgedl/chrome/chrome-for-testing/120.0.6099.71/linux64/chrome-linux64.zip",
                "/tmp/chrome-linux64.zip");
        System.out.println("Chrome browser ZIP is downloaded");

        WebFileDownloadManager.download(
                "https://edgedl.me.gvt1.com/edgedl/chrome/chrome-for-testing/120.0.6099.71/linux64/chromedriver-linux64.zip",
                "/tmp/chromedriver-linux64.zip");
        System.out.println("Chrome driver ZIP is downloaded");

        WebFileDownloadManager.download(
                "https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip",
                "/tmp/apache-maven.zip");
        System.out.println("Maven ZIP is downloaded");

        ZipManager.unzip("/tmp/chrome-linux64.zip", "/tmp/bin");
        System.out.println("Chrome browser ZIP is unzipped");

        ZipManager.unzip("/tmp/chromedriver-linux64.zip", "/tmp/bin");
        System.out.println("Chrome driver ZIP is unzipped");

        ZipManager.unzip("/tmp/apache-maven.zip", "/tmp/bin");
        System.out.println("Maven ZIP is unzipped");

        String path = System.getProperty("PATH");
        System.setProperty("PATH", path + ":/tmp/bin/apache-maven-3.9.6/bin");

        /*       MavenManager.setMavenHome("/tmp/bin/apache-maven-3.9.6");
        MavenManager.setMavenExecutable("/tmp/bin/apache-maven-3.9.6/bin/mvn");

        InvocationResult result = MavenManager.run(
                "/tmp/SeleniumAWS/pom.xml",
                "test \"-DtestSuite=/tmp/SeleniumAWS/src/test/resources/testngLambda.xml\" \"-DthreadCount=1\" \"-Dlambda=no\"");
*/
        String[] cmd  = {
                "mvn test \"-DtestSuite=/tmp/SeleniumAWS/src/test/resources/testngLambda.xml\" \"-DthreadCount=1\" \"-Dlambda=no\""
        };

        //String[] cmd = {"run-test.sh"};

        output = CommandLineExecutor.runCommandLine(cmd);
        System.out.println("Output:\n" + output);

        if (!output.contains("BUILD SUCCESS")) {
            Assert.fail(output);
        }

/*        if (result.getExitCode() != 0) {
            if (result.getExecutionException() != null) {
                System.out.println("Exception:\n" + result.getExecutionException().getMessage());
                throw new RuntimeException(result.getExecutionException());
            }
        }*/

        return "";
    }
}
