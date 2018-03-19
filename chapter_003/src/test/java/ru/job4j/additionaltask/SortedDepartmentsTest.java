package ru.job4j.additionaltask;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;



/**
 * Class SortedDepartmentsTest.
 * @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
 * @version $I$
 * @since 18.03
 */
public class SortedDepartmentsTest {

    /**
     * Test method.
     */
    @Test
    public void whenGiveListOfDepartmentsShouldReturnFullList() {
        SortedDepartments sortedDepartments = new SortedDepartments();
        List<String> departmentList = new ArrayList<>();
        departmentList.addAll(Arrays.asList("K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"));

        List<String> finalDepartmentList = new ArrayList<>();
        finalDepartmentList.addAll(Arrays.asList("K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K1", "K2\\SK1"));

        sortedDepartments.addMissDepartments(departmentList);
        assertThat(departmentList, is(finalDepartmentList));
    }
    /**
     * Test method.
     */
    @Test
    public void whenGiveListOfDepartmentsShouldSortInAscending() {
        SortedDepartments sortedDepartments = new SortedDepartments();
        List<String> departmentList = new ArrayList<>();
        departmentList.addAll(Arrays.asList("K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"));
        List<String> finalDepartmentList = new ArrayList<>();
        finalDepartmentList.addAll(Arrays.asList("K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2",
                "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"));

        sortedDepartments.sortDepartAsc(departmentList);
        assertThat(departmentList, is(finalDepartmentList));

    }
    /**
     * Test method.
     */
    @Test
    public void whenGiveListOfDepartmentsShouldSortInDescending() {
        SortedDepartments sortedDepartments = new SortedDepartments();
        List<String> departmentList = new ArrayList<>();
        departmentList.addAll(Arrays.asList("K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"));
        List<String> finalDepartmentList = new ArrayList<>();
        finalDepartmentList.addAll(Arrays.asList("K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1",
                "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"));

        sortedDepartments.sortDepartDesc(departmentList);
        assertThat(departmentList, is(finalDepartmentList));
    }



}

