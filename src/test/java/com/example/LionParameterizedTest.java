package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LionParameterizedTest {


    public static Object[][] data() {
        return new Object[][] {
                { "Самец", true},
                { "Самка", false},
        };
    }

    @ParameterizedTest
    @MethodSource("data")
    public void lionConstructorSexWithParameters(String sex, boolean hasMane) throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, mockFeline);
        assertEquals(hasMane, lion.doesHaveMane());
    }

    @ParameterizedTest
    @MethodSource("data")
    public void doesHaveManeWithParameters(String sex, boolean hasMane) throws Exception {
            Feline mockFeline = Mockito.mock(Feline.class);
            Lion lion = new Lion(sex, mockFeline);
            assertEquals(hasMane, lion.doesHaveMane());
        }




}
