package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;


public class LionTest {

    public String sex = "Самец";

    @Test
    public void getKittensWithNoParameters() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Lion lion = new Lion (sex, mockFeline);
        int expected = 1;
        Mockito.when(mockFeline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        assertEquals(expected, actual,"Ожидается один Симба");
    }

    @Test
    public void getFoodReurnsMeatBirdFish() throws Exception {
        Feline spyFeline = spy(new Feline());
        Lion lion = new Lion (sex, spyFeline);
        Mockito.when(spyFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = lion.getFood();
        Mockito.verify(spyFeline, times(1)).getFood("Хищник");
        assertEquals(expected, actual, "Львы - это хищники, поэтому едят животных, птицу, рыбу");
        }

    @Test
    void getFoodThrowsException() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Lion lion = new Lion (sex, mockFeline);
        Mockito.when(mockFeline.eatMeat()).thenThrow(new Exception("Ошибка получения еды"));
        try {
            lion.getFood();
        } catch (Exception exception) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        }
        Mockito.verify(mockFeline, times(1)).getFood("Хищник");
    }
}