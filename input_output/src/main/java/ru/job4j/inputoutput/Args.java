package ru.job4j.inputoutput;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Args.
 */
public class Args {
    private String srcDir;
    private String zip;
    private String ext;

    List<String> exts = new ArrayList<>();

    public List<String> getExts() {
        return exts;
    }

    public String getSrcDir() {

        return srcDir;
    }

    public String getZip() {
        return zip;
    }

    /**
     * Constructor.
     *
     * @param args arguments.
     */
    public Args(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-d")) {
                srcDir = args[i + 1];
            }
            if (args[i].equals("-e")) {
                ext = args[i + 1];
            }
            if (args[i].equals("-o")) {
                zip = args[i + 1];
            }
        }

        exts.add(this.ext);

    }
}
