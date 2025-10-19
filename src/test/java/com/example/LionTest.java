package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

class LionTest {

    @Mock
    Feline mockFeline;

    public String sex = "Самец";

    @Test
    void testGetKittensWithNoParams() throws Exception {

        Lion lion = new Lion (sex, mockFeline);
        int expected = 1;
        Mockito.when(mockFeline.getKittens()).thenReturn(1); // для возврата нужного значения в методе
        int actual = lion.getKittens();
        assertEquals(expected, actual,"Ожидается один Симба");
    }

    @Test
    void testLionGetFood() throws Exception {
        Lion lion = new Lion (sex, mockFeline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        Mockito.verify(mockFeline, times(1)).getFood("Хищник");
        assertEquals(expected, actual, "Львы - это хищники, поэтому едят животных, птицу, рыбу");
        }
    }
}