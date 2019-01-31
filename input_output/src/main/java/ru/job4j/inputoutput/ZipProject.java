package ru.job4j.inputoutput;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Class ZipProject.
 */
public class ZipProject {

    public static void main(String[] args) {
        Args arg = new Args(args);
        new ZipProject().zip(arg.getExts(), arg.getSrcDir(), arg.getZip());
    }


    /**
     * method to zip files with an appropriate extension.
     *
     * @param srcDir source directory.
     * @param exts   files´ extension.
     * @param zip    zipped directory.
     */
    public void zip(List<String> exts, String srcDir, String zip) {
        byte[] buffer = new byte[1024];
        Search search = new Search();
        try {
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zip));
            List<File> files = search.files(srcDir, exts);
            for (int i = 0; i < files.size(); i++) {
                File tempfile = files.get(i);
                FileInputStream fis = new FileInputStream(tempfile);
                zos.putNextEntry(new ZipEntry(tempfile.getAbsolutePath()));
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, length);
                }
                zos.closeEntry();
                fis.close();
            }
            zos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
