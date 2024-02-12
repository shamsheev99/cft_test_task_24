package filehadlers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class FileWriterAbstract {
    protected String filePath;
    protected FileOutputStream fos;
    protected int count = 0;
    protected boolean overwrite;

    protected FileWriterAbstract(String filePath, boolean overwrite) {
//        fos = new FileOutputStream(filePath, overwrite);
        this.filePath = filePath;
        this.overwrite = overwrite;

    }
//
//    public abstract void FIleWriterAdapterBuilder(String filePath, boolean overwrite);
    public void writeToFile(String message) throws FileNotFoundException {
        if (count == 0) {
            fos = new FileOutputStream(filePath, overwrite);
        }
        System.out.println(filePath + "   TUTA PISHET MESASGE    /" + message);
        try {
            fos.write((message + System.lineSeparator()).getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        count++;
    }
    public void close() throws IOException {
        if (count != 0) fos.close();
    }
}
