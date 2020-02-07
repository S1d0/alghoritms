package pl.my.alghoritms.examples.alghoritms;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class UglyNumbersTest {

    @Test
    void should_return_1() {
        // given
        int position = 1;

        // then
        assertEquals(1, UglyNumbers.getUgly(position));
    }

    @Test
    void should_return_8() {
        // given
        int position = 7;

        // then
        assertEquals(8, UglyNumbers.getUgly(position));
    }

    @Test
    void should_return_12() {
        // given
        int position = 10;

        // then
        assertEquals(12, UglyNumbers.getUgly(position));
    }

    @Test
    void should_return_24() {
        // given
        int position = 15;

        // then
        assertEquals(24, UglyNumbers.getUgly(position));
    }

    @Test
    void should_return_5832 () {
        // given
        int position = 150;

        // then
        assertEquals(5832, UglyNumbers.getUgly(position));
    }
}