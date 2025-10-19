package com.example;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int kittensCount;
    private final int expectedKittensCount;

    public FelineParameterizedTest(int kittensCount, int expectedKittensCount) {
        this.kittensCount = kittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensCount() {
        return new Object[][] {
                { 1, 1},
                { 2, 2},
                { 0, 0},
                { -1, -1},
        };
    }

    @Test
    void testGetKittensWithParameter() {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittensCount);
        assertEquals(actual, expectedKittensCount, "Ожидается целое количество котят");
    }

}
