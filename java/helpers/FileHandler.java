package helpers;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private String path;

    public FileHandler(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public ArrayList<String> readFile() {
        ArrayList<String> lines = new ArrayList<>();
        String lineRead;

        try(BufferedReader reader = new BufferedReader(new FileReader(this.getPath()))) {
            lineRead = reader.readLine();
            while (lineRead != null) {
                lines.add(lineRead);
                lineRead = reader.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public String readFileOneLine() {
        String line = null;

        try(BufferedReader reader = new BufferedReader(new FileReader(this.getPath()))) {
            line = reader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }
}
