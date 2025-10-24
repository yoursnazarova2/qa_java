package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Executable;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

public class CatTest {

    @Test
    public void getSoundReturnsMeow() {
        Feline mockFeline = Mockito.mock(Feline.class);
        Cat cat = new Cat((mockFeline));
        String expected = "Мяу";
        String actual = cat.getSound();
        assertEquals(expected, actual, "Котик должен мяукать");
    }


    @Test
    public void getFoodReturnsMeatBirdFish() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Cat cat = new Cat(mockFeline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.eatMeat()).thenReturn(expected);
        List<String> actual = cat.getFood();
        Mockito.verify(mockFeline, times(1)).eatMeat();
        assertEquals(expected, actual, "Коты - это хищники, поэтому едят животных, птицу, рыбу");
    }

    @Test
    public void getFoodThrowsException() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Mockito.when(mockFeline.eatMeat()).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
        Cat cat = new Cat(mockFeline);
        Exception exception = assertThrows(Exception.class, () -> cat.getFood());
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        Mockito.verify(mockFeline, times(1)).eatMeat();
    }
}