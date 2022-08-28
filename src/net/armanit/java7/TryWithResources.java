package net.armanit.java7;

import net.armanit.util.CustomResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) throws Exception{
        beforeJava7();
        afterJava7();
        withCustomResInJava();
    }

    static void beforeJava7() throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/Users/mubeenarman/project/java/Java7/java7-feature/text.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            br.close();
        }
    }

    static void  afterJava7() throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader("/Users/mubeenarman/project/java/Java7/java7-feature/text.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    static void withCustomResInJava() throws Exception{
        try(CustomResource cr = new CustomResource()) {
            cr.readFromResource();
        }
    }
}
