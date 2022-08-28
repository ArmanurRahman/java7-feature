package net.armanit.util;

public class CustomDirtyResource implements AutoCloseable{
    @Override
    public void close() throws Exception {
        throw new NullPointerException("OOPs Null Pointer exception occurs");
    }

    public void readFromResource() {
        throw new RuntimeException("I am sorry. I don't have data available right now due to network issue !!!");
    }
}
