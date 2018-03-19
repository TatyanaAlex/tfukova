package ru.job4j.additionaltask;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class SortedDepartments.
 * @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
 * @version $I$
 * @since 18.03
 */
public class SortedDepartments {

    /**
     * Method to add missed departments to the list of departments.
     * @param departmentList list of departments.
     */
    public void addMissDepartments(List<String> departmentList) {

        List<String> sortedList = new ArrayList<>();
        sortedList.addAll(departmentList);
        for (String sort : sortedList) {
            while (sort.contains("\\")) {
                sort = sort.substring(0, sort.lastIndexOf("\\"));
                if (!departmentList.contains(sort)) {
                    departmentList.add(sort);
                }
            }
        }
    }
    /**
     * Method to sort the departments in ascending order.
     * @param departmentList list of departments.
     */
    public void sortDepartAsc(List<String> departmentList) {
        addMissDepartments(departmentList);
        departmentList.sort(new Comparator<String>() {
                                @Override
                                public int compare(String o1, String o2) {
                                    return o1.compareTo(o2);
                                }
                            }
        );
    }

    /**
     * Method to sort the departments in descending order.
     * @param departmentList list of departments.
     */
    public void sortDepartDesc(List<String> departmentList) {
        addMissDepartments(departmentList);
        departmentList.sort(new Comparator<String>() {
                                @Override
                                public int compare(String o1, String o2) {
                                    if (o1.startsWith(o2)) {
                                        return 1;
                                    } else if (o2.startsWith(o1)) {
                                        return -1;
                                    } else {
                                        return o2.compareTo(o1);
                                    }

                               }
        }
        );

    }


}
