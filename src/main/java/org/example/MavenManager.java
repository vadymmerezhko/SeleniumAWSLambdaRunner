package org.example;

import org.apache.maven.shared.invoker.*;

import java.io.File;
import java.util.Arrays;

public class MavenManager {

    private static final Invoker invoker = new DefaultInvoker();

    public static void setMavenExecutable(String mavenExecutablePath) {
        invoker.setMavenExecutable(new File(mavenExecutablePath));
    }

    public static void setMavenHome(String mavenHomePath) {
        invoker.setMavenHome(new File(mavenHomePath));
    }

    public static InvocationResult run(String pomFilePath, String... goals ) {

        try {
            InvocationRequest request = new DefaultInvocationRequest();
            request.setPomFile(new File(pomFilePath) );
            request.setGoals(Arrays.asList(goals));

            return invoker.execute(request);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
