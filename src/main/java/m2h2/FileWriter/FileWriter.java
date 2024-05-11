package m2h2.FileWriter;

import java.io.IOException;

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


}
