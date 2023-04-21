package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    @Mock
    Feline felineMock;
    private final String sex;
    private final boolean hasMane;

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getLion() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
                {"sadasdsa", true},
                {" ", false}
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getKittens() throws Exception {
        if (sex == "Самец" || sex == "Самка") {
            Lion lion = new Lion(sex, felineMock);
            Mockito.when(felineMock.getKittens()).thenReturn(1);
            Assert.assertEquals(felineMock.getKittens(), lion.getKittens());
        } else {
            Exception exception = Assert.assertThrows(Exception.class, () -> {
                new Lion(sex, felineMock);
            });

            String actualString = exception.getMessage();
            String exceptedString = "Используйте допустимые значения пола животного - самей или самка";

            Assert.assertTrue(actualString.contains(exceptedString));
        }

    }

    @Test
    public void doesHaveMane() {
        try {
            Lion lion = new Lion(sex, felineMock);
            Assert.assertEquals(hasMane, lion.doesHaveMane());
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().contains("Используйте допустимые значения пола животного - самей или самка"));
        }

    }

    @Test
    public void getFood() {
        try {
            Lion lion = new Lion(sex, felineMock);
            Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            Assert.assertEquals(felineMock.getFood("Хищник"), lion.getFood());
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().contains("Используйте допустимые значения пола животного - самей или самка"));
        }
    }

}