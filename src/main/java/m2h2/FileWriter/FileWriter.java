package m2h2.FileWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public  class FileWriter {

    public static void WriteToFile(String data, String path, boolean reset) {

        boolean resetFile;

        try {

        if (reset) {
            resetFile = false;
        } else {
            resetFile = true;
        }

            java.io.FileWriter writer = new java.io.FileWriter(path, resetFile);
            writer.write(data);

            // Close the writer
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public static void deleteFolderContents(String pad) throws IOException {
        Path directory = Paths.get(pad);
        Files.walk(directory)
                .filter(path -> !path.equals(directory)) // Exclude the root folder itself
                .forEach(path -> {
                    try {
                        Files.delete(path);
                    } catch (IOException e) {
                        // Handle file deletion failure
                        e.printStackTrace();
                    }
                });
    }


}
