package org.example;

import org.apache.maven.shared.invoker.*;

import java.io.File;
import java.util.Arrays;

public class MavenManager {

    public static InvocationResult run(String pomFilePath, String... goals ) {

        try {
            InvocationRequest request = new DefaultInvocationRequest();
            request.setPomFile( new File(pomFilePath) );
            request.setGoals(Arrays.asList(goals));

            Invoker invoker = new DefaultInvoker();
            return invoker.execute(request);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
