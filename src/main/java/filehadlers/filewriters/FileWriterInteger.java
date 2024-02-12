package filehadlers.filewriters;

import filehadlers.FileWriterAbstract;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileWriterInteger extends FileWriterAbstract {
    public FileWriterInteger(String filePath, boolean overwrite) throws FileNotFoundException {
        super(filePath+"integer.txt", overwrite);
    }

}
