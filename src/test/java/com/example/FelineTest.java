package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    Animal animalMock;

    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        Mockito.when(animalMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(animalMock.getFood("Хищник"), feline.eatMeat());
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        Mockito.when(animalMock.getFamily()).thenReturn("Кошачьи");
        Assert.assertEquals(animalMock.getFamily(), feline.getFamily());
    }

    @Test
    public void getKittensTest() {
        Feline feline = new Feline();
        Assert.assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        Assert.assertEquals(5, feline.getKittens(5));
    }
}