package com.example;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
class FelineTest {

    @Test
    void testFelineGetFoodReturnsMeatBirdFish() throws Exception { //mock
        Feline feline = spy(new Feline());
        List<String> expected = List.of("Мясо", "Курица", "Лосось на пару");
        List<String> actual = feline.eatMeat();
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        assertEquals(expected, actual, "Кошачьи - это хищники, поэтому едят животных, птицу, рыбу");
        Mockito.verify(feline.getFood("Хищник"));
    }

    @Test
    void testGetFelineFamily() { //mock
        Feline feline = new Feline();
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expected, actual, "Метод getFamily() для Feline должен возвращать Кошачьи");
    }

    @Test
    void testGetKittensWithNoParams() {
        Feline feline = new Feline();
        int expected = 1;
        int actual = feline.getKittens(1);
        assertEquals(expected, actual,"Ожидается один сладкий котенок");
    }

}