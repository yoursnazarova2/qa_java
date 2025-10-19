package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    @Mock
    Feline mockFeline; // мок нужен, чтобы не зависеть от класса Feline

    private final String sex;
    private final boolean hasMane;

    public LionParameterizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    @CsvSource({
                "Самец, true",
                "Самка, false"
        })

    @Test
    void testDoesHaveMane(String gender, boolean isMane) throws Exception {
            Lion lion = new Lion(sex, mockFeline);
            assertEquals(hasMane, lion.doesHaveMane());
        }
}
