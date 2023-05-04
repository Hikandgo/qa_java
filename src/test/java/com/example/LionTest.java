package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Enclosed.class)
public class LionTest {
    @RunWith(Parameterized.class)
    public static class LionTestPositive {
        @Mock
        Feline felineMock;
        private final String sex;
        private final boolean hasMane;

        public LionTestPositive(String sex, boolean hasMane) {
            this.sex = sex;
            this.hasMane = hasMane;
        }

        @Parameterized.Parameters
        public static Object[][] getLion() {
            return new Object[][] {
                    {"Самец", true},
                    {"Самка", false},
            };
        }

        @Before
        public void init() {
            MockitoAnnotations.initMocks(this);
        }

        @Test
        public void getKittens() throws Exception {
            Lion lion = new Lion(sex, felineMock);
            Mockito.when(felineMock.getKittens()).thenReturn(1);
            Assert.assertEquals(felineMock.getKittens(), lion.getKittens());
        }

        @Test
        public void doesHaveMane() throws Exception{
            Lion lion = new Lion(sex, felineMock);
            Assert.assertEquals(hasMane, lion.doesHaveMane());
        }

        @Test
        public void getFood() throws Exception {
            Lion lion = new Lion(sex, felineMock);
            Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            Assert.assertEquals(felineMock.getFood("Хищник"), lion.getFood());
        }
    }

    public static class LionTestNegative {
        @Mock
        Feline felineMock;
        @Test
        public void getThrowMale() {
            try {
                String sex = " ";
                Lion lion = new Lion(sex, felineMock);
            } catch (Exception e) {
                Assert.assertTrue(e.getMessage().equals("Используйте допустимые значения пола животного - самей или самка"));
            }
        }
    }
}

