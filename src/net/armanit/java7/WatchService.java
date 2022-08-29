package net.armanit.java7;

import java.nio.file.*;

public class WatchService {

    public static void main(String[] args) throws Exception{
        directoryWatchService();
    }
    private static void directoryWatchService() throws Exception{
        java.nio.file.WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get("/Users/mubeenarman/project/java/test");
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE);

        boolean poll = true;
        WatchKey key = watchService.take();
        while (poll) {
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println("Event kind : " + event.kind() + " - for the file : " + event.context());
            }
            poll = key.reset();
        }
    }
}
