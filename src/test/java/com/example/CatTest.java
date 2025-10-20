package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
        Mockito.when(mockFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = cat.getFood();
        Mockito.verify(mockFeline, times(1)).eatMeat();
        assertEquals(expected, actual, "Коты - это хищники, поэтому едят животных, птицу, рыбу");
    }

    @Test
    public void getFoodThrowsException() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Mockito.when(mockFeline.eatMeat()).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
        Cat cat = new Cat(mockFeline);
        try {
            cat.getFood();
        } catch (Exception exception) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        }
        Mockito.verify(mockFeline, times(1)).eatMeat(); // допольнительно убедимся, что действительно вызвали нужный метод и 1 раз
    }
}