package net.armanit.java7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SafeVarExample {

    public static void main(String[] args) {
        sum(1);
        sum(1, 2);
        sum(1, 2, 3);

        SafeVarExample safeVarExample = new SafeVarExample();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();

        list1.add("Mubeen");
        list2.add("Arman");
        list3.add("Java");

        safeVarExample.print(list1, list2, list3);
    }

    @SafeVarargs
    public final void print(List<String>... message) {
        String firstElement = message[0].get(0);
        System.out.println(firstElement);
    }

    private static void sum(int... nums) {
        System.out.println(Arrays.toString(nums));
        int sum=0;
        for (int num : nums) {
            sum += num;
        }
        System.out.println("The total sum for the given input is : " + sum);
    }
}
