package ru.job4j.testtask;


/**
 * Class Args.
 */
public class Args {

    private String srcDir;
    private String name;
    private boolean mask = false;
    private boolean fullNameMatch = false;
    private boolean regex = false;
    private String resultFileName;


    public boolean isMask() {
        return mask;
    }

    public boolean isFullNameMatch() {
        return fullNameMatch;
    }

    public boolean isRegExpression() {
        return regex;
    }

    public String getSrcDir() {
        return srcDir;

    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return resultFileName;
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
            if (args[i].equals("-n")) {
                name = args[i + 1];
            }
            if (args[i].equals("-m")) {
                mask = true;
            }
            if (args[i].equals("-f")) {
                fullNameMatch = true;
            }
            if (args[i].equals("-r")) {
                regex = true;
            }
            if (args[i].equals("-o")) {
                resultFileName = args[i + 1];
            }
        }

    }
}
