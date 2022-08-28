package net.armanit.util;

public class CustomResource implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("From close method inside the custom resource class");
    }

    public void readFromResource() {
        System.out.println("Reading data");
    }
}
