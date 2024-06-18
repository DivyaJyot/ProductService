package com.scaledivya.ProductService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SamplTest {
    @Test
    void testOnePlusOneTwo(){
        int i=1+1;// arrange and act;
        assert i==2;
    }

@Test
    void test2in2four(){
        int i=2*2;
        int j= 5*5;
        assert i==4;
        assert j==25;// this comes from JUinit automatically
    //in assert condition first param is expected & second is actual
       assertEquals(j,25, "Failed--its not 7");// we need to add Assertj in dependency
       assertNotEquals(j,6);

    }
}
