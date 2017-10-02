package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ContainWordTest{
    @Test
    public void WhenOneStringContainsSubstring(){
        ContainWord contain = new ContainWord();

        boolean rsl = contain.contains("Привет","иве" );
        assertThat(rsl, is(true));
    }

}