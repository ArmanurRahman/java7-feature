package net.armanit.java7;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CatchMultipleExpression {
    private final static Logger LOGGER = Logger.getLogger(CatchMultipleExpression.class.getName());
    public static void main(String[] args) {
        beforeJava7();
        afterJava7();
    }

    static void beforeJava7() {
        int arr[] = {1, 2, 3, 4, 5};

        try {
            for (int i=0; i<arr.length + 1; i++) {
                System.out.println(arr[i]);
            }
        } catch (NullPointerException exception) {
            LOGGER.log(Level.SEVERE, exception.getMessage());
        } catch (ArrayIndexOutOfBoundsException aioex) {
            LOGGER.log(Level.SEVERE, aioex.getMessage());
        }
    }

    static void afterJava7() {
        int arr[] = {1, 2, 3, 4, 5};
        try {
            for (int i=0; i<arr.length + 1; i++) {
                System.out.println(arr[i]);
            }
        } catch (NullPointerException | ArrayIndexOutOfBoundsException exception) {
            LOGGER.log(Level.SEVERE, exception.getMessage());
        }
    }
}
