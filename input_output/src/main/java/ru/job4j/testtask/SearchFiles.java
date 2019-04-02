package ru.job4j.testtask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class SearchFiles.
 */
public class SearchFiles {

    public static void main(String[] args) {
        //args = new String[]{"-d", "/Users/tatyanafukova/Desktop", "-n", "*.txt", "-m", "-o", "log.txt"};
        Args arg = new Args(args);
        SearchFiles sf = new SearchFiles();
        sf.searchFiles(arg);
    }

    /**
     * method to search files in a src directory.
     *
     * @param arg arguments.
     */
    private void searchFiles(Args arg) {
        if (arg.getSrcDir() != null) {
            File parentPath = new File(arg.getSrcDir());
            List<File> result = new ArrayList<>();
            Queue<File> tree = new PriorityQueue<>();
            Collections.addAll(tree, parentPath.listFiles());
            while (!tree.isEmpty()) {
                File temp = tree.remove();
                if (temp.isDirectory()) {
                    Collections.addAll(tree, temp.listFiles());
                } else if (matchName(arg, temp)) {
                    result.add(temp);
                }
            }
            try {
                FileOutputStream fos = new FileOutputStream(arg.getResult());
                for (File resultFile : result) {
                    fos.write(resultFile.getAbsolutePath().getBytes());
                }
                fos.close();
            } catch (IOException e) {
                printHelp("file directory doesn´t exist");
            }
        } else {
            printHelp("file directory is mandatory");
        }


    }

    /**
     * method to compare file´s name with searched name.
     *
     * @param arg arguments.
     */
    private boolean matchName(Args arg, File temp) {
        boolean matched = false;

        if (arg.isFullNameMatch() && arg.getName().equals(temp.getName())) {
            matched = true;
        } else if (arg.isMask()) {
            Pattern pattern = Pattern.compile(arg.getName().replace("*", ".*"), Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(temp.getName());
            if (matcher.matches()) {
                matched = true;
            }

        } else if (arg.isRegExpression() && temp.getName().matches(arg.getName())) {
            matched = true;
        } else {
            printHelp("missing search mode");
        }
        return matched;
    }

    /**
     * method to print keys´ hint.
     *
     * @param str information.
     */
    private void printHelp(String str) {
        System.err.println("Input is incorrect: " + str);
        System.out.println("-d - директория в которая начинать поиск.\n"
                + "-n - имя файл, маска, либо регулярное выражение.\n"
                + "-m - искать по маске, либо -f - полное совпадение имени. -r регулярное выражение.\n"
                + "-o - результат записать в файл.");
    }

}
