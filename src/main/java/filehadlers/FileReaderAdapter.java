package filehadlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderAdapter {
    private Scanner scanner;

    public FileReaderAdapter(String filePath) {
        try {
            scanner = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public String readNext() {
        return scanner.next();
    }

    public boolean hasNext() {
        return scanner.hasNext();
    }
}
