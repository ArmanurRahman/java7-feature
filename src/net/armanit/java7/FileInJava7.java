package net.armanit.java7;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileInJava7 {
    private static String HOME_DIR = "/Users/mubeenarman/project/java/Java7/";

    public static void main(String[] args) throws IOException{
        workingWithFiles();
    }

    private static void workingWithFiles() throws IOException {
        Path path = Paths.get(HOME_DIR, "java7-feature", "Test.txt");
        byte[] bytes = Files.readAllBytes(path);
        String content = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("Content of file is " + content );

        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        for (String line : lines) {
            System.out.println("Content of line is " + line);
        }

        String newLine = "Java 9";
        Files.write(path, newLine.getBytes(), StandardOpenOption.APPEND);

        Path newPath = Paths.get(HOME_DIR, "Java8");
        Files.createDirectories(newPath);
        Path filePath = Paths.get(HOME_DIR, "Java8","Hello.txt");
        Files.createFile(filePath);

        Files.delete(filePath);
        boolean deleted = Files.deleteIfExists(filePath);
        System.out.println(deleted);
    }
}
