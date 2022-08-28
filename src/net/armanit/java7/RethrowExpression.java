package net.armanit.java7;

public class RethrowExpression {
    public static void main(String[] args) throws Exception{
//        beforeJava7("first");
        afterJava7("first");
    }

    static void beforeJava7(String expressionName) throws Exception {
        try {
            if (expressionName.equals("first")) {
                throw new FirstExpression();
            } else {
                throw new SecondExpression();
            }
        } catch (Exception ex) {
            throw ex;
        }

    }

    static void afterJava7(String expressionName) throws FirstExpression, SecondExpression{
        try {
            if (expressionName.equals("first")) {
                throw new FirstExpression();
            } else {
                throw new SecondExpression();
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    static class FirstExpression extends Exception {}

    static class SecondExpression extends Exception {}
}
