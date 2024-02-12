package filehadlers.filewriters;

import filehadlers.FileWriterAbstract;

import java.io.FileNotFoundException;

public class FileWriterFloat extends FileWriterAbstract {
    public FileWriterFloat(String filePath, boolean overwrite) throws FileNotFoundException {
        super(filePath+"float.txt", overwrite);
    }
}
