package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;

public class FelineTest {

    @Test
    public void eatMeatReturnsMeatBirdFish() throws Exception { //mock
        Feline spyFeline = spy(new Feline());
        List<String> expected = List.of("Мясо", "Курица", "Лосось на пару");
        Mockito.when(spyFeline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = spyFeline.eatMeat();
        assertEquals(expected, actual, "Кошачьи - это хищники, поэтому едят животных, птицу, рыбу");
        Mockito.verify(spyFeline).getFood("Хищник");
    }

    @Test
    public void getFamilyReturnsFeline() { //mock
        Feline feline = new Feline();
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expected, actual, "Метод getFamily() для Feline должен возвращать Кошачьи");
    }

    @Test
    public void getKittensWithNoParameters() {
        Feline feline = new Feline();
        int expected = 1;
        int actual = feline.getKittens();
        assertEquals(expected, actual,"Ожидается один сладкий котенок");
    }
}