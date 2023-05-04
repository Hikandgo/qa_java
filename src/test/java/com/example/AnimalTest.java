package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalTest {

    private final String animalKind;

    public AnimalTest(String animalKind) {
        this.animalKind = animalKind;
    }

    @Parameterized.Parameters
    public static Object[][] getKind() {
        return new Object[][]{
                {"Травоядное"},
                {"asdasdas"}
        };
    }

    @Test
    public void getFood() {
        try {
            Animal animal = new Animal();
            Assert.assertEquals(List.of("Трава", "Различные растения"), animal.getFood(animalKind));
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().contains("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
        }

    }

    @Test
    public void getFamily() {
        Animal animal = new Animal();
        Assert.assertTrue(animal.getFamily().contains("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи"));
    }
}