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
        List<File> result = new ArrayList<>();
        Queue<File> tree = new PriorityQueue<>();
        Collections.addAll(tree, parentPath.listFiles());
        while (!tree.isEmpty()) {
            File temp = tree.remove();
            if (temp.isDirectory()) {
                Collections.addAll(tree, temp.listFiles());
            } else if (exts.contains(cutExt(temp))) {
                result.add(temp);
            }
        }
        return result;

    }

    public String cutExt(File temp) {
        String extension = "";
        int i = temp.getName().lastIndexOf('.');
        if (i >= 0) {
            extension = temp.getName().substring(i + 1);
        }
        return extension;
    }
}
