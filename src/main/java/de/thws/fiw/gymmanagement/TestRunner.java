package de.thws.fiw.gymmanagement;

import org.apache.maven.shared.invoker.*;

import java.io.File;
import java.util.Arrays;

public class TestRunner {
    public static void main(String[] args) {
        System.out.println("Starting integration tests...");

        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile(new File("/pom-docker.xml"));
        request.setGoals(Arrays.asList("", "test")); // Runs the tests

        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File("/usr/share/maven")); // Adjust the path based on your image
        //invoker.setMavenHome(new File("/usr/share/maven")); // Adjust the path based on your image

        try {
            int exitCode = invoker.execute(request).getExitCode();
            if (exitCode == 0) {
                System.out.println("Tests completed successfully.");
                System.exit(0);
            } else {
                System.err.println("Tests failed.");
                System.exit(1);
            }
        } catch (MavenInvocationException e) {
            System.err.println("Error executing Maven tests: " + e.getMessage());
            System.exit(1);
        }
    }
}
