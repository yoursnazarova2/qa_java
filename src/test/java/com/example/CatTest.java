package com.example;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
class CatTest {

    @Mock
    Predator mockPredator;

    @Test
    void testGetSound() {
        Cat cat = new Cat((Feline) mockPredator);
        String expected = "Мяу";
        String actual = cat.getSound();
        assertEquals(expected, actual, "Котик должен мяукать"); // здесь не использую Mockito, потому что в методе нет аругментов - тестирую, что метода возвращает
    }


    @Test
    void testCatGetFoodReturnsMeatBirdFish() throws Exception {
        Cat cat = new Cat((Feline) mockPredator);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(mockPredator.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба")); // иначе метод вернет null
        List<String> actual = cat.getFood(); // если тест не падает, значит, под капотом в cat.getFood() вызывается predator.eatMeat()
        Mockito.verify(mockPredator, times(1)).eatMeat(); // проверяем, что действительно вызвали 1 раз нужный метод
        assertEquals(expected, actual, "Коты - это хищники, поэтому едят животных, птицу, рыбу");
    }

    @Test
    void testCatGetFoodThrowsException() throws Exception {
        Mockito.when(mockPredator.eatMeat()).thenThrow(new Exception("Ошибка получения еды"));
        Cat cat = new Cat((Feline) mockPredator);
        try {
            cat.getFood();
        } catch (Exception exception) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        }
        Mockito.verify(mockPredator, times(1)).eatMeat(); // допольнительно убедимся, что действительно вызвали нужный метод и 1 раз
    }
}