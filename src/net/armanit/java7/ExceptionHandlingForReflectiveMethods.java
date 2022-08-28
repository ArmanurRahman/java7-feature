package net.armanit.java7;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExceptionHandlingForReflectiveMethods {
    private final static Logger LOGGER = Logger.getLogger(ExceptionHandlingForReflectiveMethods.class.getName());

    public static void main(String[] args) {
        beforeJava7();
        withJava7();
    }

    static void beforeJava7() {
        try {
            Class.forName("net.armanit.java7.ExceptionHandlingForReflectiveMethods")
                    .getMethod("withJava7").invoke(null, new Object[] {});
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException ex) {
            LOGGER.log(Level.SEVERE, ex.toString());
        }
    }

    static void withJava7() {
        try {
            Class.forName("net.armanit.java7.ExceptionHandlingForReflectiveMethods")
                    .getMethod("withJava7").invoke(null, new Object[] {});
        } catch (ReflectiveOperationException ex) {
            LOGGER.log(Level.SEVERE, ex.toString());
        }
    }
}
