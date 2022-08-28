package net.armanit.java7;

import net.armanit.util.CustomDirtyResource;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SupressedExpression {

    private final static Logger LOGGER = Logger.getLogger(SupressedExpression.class.getName());
    public static void main(String[] args) {
        try {
            beforeJava7();
        }catch (Exception exception) {
            LOGGER.log(Level.SEVERE, exception.getMessage());
        }

        try {
            afterJava7();
        }catch (Exception exception) {
            LOGGER.log(Level.SEVERE, exception.getMessage());
            final Throwable[] suppressedException = exception.getSuppressed();
            final int numSuppressed = suppressedException.length;

            if (numSuppressed > 0) {
                for (final Throwable ex : suppressedException) {
                    LOGGER.log(Level.SEVERE, ex.getMessage());
                }
            }
        }
    }

    static void beforeJava7() throws Exception{
        CustomDirtyResource cr = null;
        try {
            cr = new CustomDirtyResource();
            cr.readFromResource();
        } finally {
            cr.close();
        }
    }

    static void afterJava7() throws Exception {
        try (CustomDirtyResource cr = new CustomDirtyResource()){
            cr.readFromResource();
        }
    }
}
