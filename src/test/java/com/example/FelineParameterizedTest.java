package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FelineParameterizedTest {

    public static Object[][] data() {
        return new Object[][] {
                { 1, 1},
                { 2, 2},
                { 0, 0},
                { -1, -1},
        };
    }

    @ParameterizedTest
    @MethodSource("data")
    public void getKittensWithParameters(int kittensCount, int expectedKittensCount) {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittensCount);
        assertEquals(expectedKittensCount, actual,"Ожидается кол-во котят, равное kittensCount");
    }

}
