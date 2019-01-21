package ru.job4j.inputoutput;

import java.io.File;
import java.util.*;

/**
 * Class Search.
 */
public class Search {

    /**
     * method to return files with an appropriate extension.
     *
     * @param parent path to parent file.
     * @param exts   files´ extension.
     * @return list of files with a given extension.
     */
    public List<File> files(String parent, List<String> exts) {

        File parentPath = new File(parent);

        List<File> resultList = new ArrayList<>();
        Queue<File> filesTree = new PriorityQueue<>();

        Collections.addAll(filesTree, parentPath.listFiles());
        while (!filesTree.isEmpty()) {
            File tempFile = filesTree.remove();
            if (tempFile.isDirectory()) {
                Collections.addAll(filesTree, tempFile.listFiles());
            } else {
                String extension = "";
                int i = tempFile.getName().lastIndexOf('.');
                if (i >= 0) {
                    extension = tempFile.getName().substring(i + 1);
                }
                if (exts.contains(extension)) {
                    resultList.add(tempFile);
                }

            }
        }
        return resultList;

    }
}
