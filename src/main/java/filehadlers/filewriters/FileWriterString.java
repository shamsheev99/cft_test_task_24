package filehadlers.filewriters;

import filehadlers.FileWriterAbstract;

import java.io.FileNotFoundException;

public class FileWriterString extends FileWriterAbstract {
    public FileWriterString(String filePath, boolean overwrite) throws FileNotFoundException {
        super(filePath+"string.txt", overwrite);
    }
}
