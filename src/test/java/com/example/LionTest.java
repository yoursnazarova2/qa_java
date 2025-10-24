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
    public void lionConstructorSexInvalidThrowsException() {
        Feline mockFeline = Mockito.mock(Feline.class);
        Exception exception = assertThrows(Exception.class, () -> new Lion("Invalid", mockFeline));
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }

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
    public void getFoodReturnsMeatBirdFish() throws Exception {
        Feline spyFeline = spy(new Feline());
        Lion lion = new Lion (sex, spyFeline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(spyFeline.eatMeat()).thenReturn(expected);
        List<String> actual = lion.getFood();
        Mockito.verify(spyFeline, times(1)).getFood("Хищник");
        assertEquals(expected, actual, "Львы - это хищники, поэтому едят животных, птицу, рыбу");
        }

    @Test
    public void getFoodThrowsException() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Mockito.when(mockFeline.getFood("Хищник")).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
        Lion lion = new Lion (sex, mockFeline);
        Exception exception = assertThrows(Exception.class, () -> lion.getFood());
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        Mockito.verify(mockFeline, times(1)).getFood("Хищник");
    }
}