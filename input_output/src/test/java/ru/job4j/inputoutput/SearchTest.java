package ru.job4j.inputoutput;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Class SearchTest.
 */
public class SearchTest {

    /**
     * Test method.
     */
    @Test
    public void whenSearchShouldReturnFiles() {

        Search search = new Search();

        String parentPath = System.getProperty("java.io.tmpdir") + "newJavaTest";
        List list = new ArrayList();
        list.add("pdf");
        list.add("jpg");

        List resultList = new ArrayList();
        resultList.add(new File(parentPath + "/A1/AES Print.pdf"));
        resultList.add(new File(parentPath + "/B1/ВОТ.jpg"));


        assertThat(search.files(parentPath, list), is(resultList));

    }


}
