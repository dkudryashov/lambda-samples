package com.dkudryashov.lambda;

/**
 * Created by d.kudryashov on 11.03.2016.
 */

import org.junit.Test;
import java.util.Comparator;
import java.util.function.Predicate;

import static org.junit.Assert.*;

/**
 * Лямбды захват тест
 */
public class CaptureTest {

    /**
     * Компаратор который выводит int:
     * 0 - (x = y)
     * 1 - (x > y)
     * 2 - (x < y)
     */
    @Test
    public void testDefault(){
        final int minus_one = -1;
        final int zero = 0;
        final int one = 1;

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return (x < y) ? minus_one : ((x > y) ? one : zero);
            }
        };

        assertEquals(-1, comparator.compare(1, 2));
        assertEquals(0, comparator.compare(100, 100));
        assertEquals(1, comparator.compare(200, 1));
    }

    /**
     * Компаратор который выводит int (lambda):
     * 0 - (x = y)
     * 1 - (x > y)
     * 2 - (x < y)
     */
    @Test
    public void testLambda(){
        final int minus_one = -1;
        final int zero = 0;
        final int one = 1;

        Comparator<Integer> comparator = (x, y) -> (x < y) ? minus_one : ((x > y) ? one : zero);

        assertEquals(-1, comparator.compare(1, 2));
        assertEquals(0, comparator.compare(100, 100));
        assertEquals(1, comparator.compare(200, 1));
    }


    /**
     * Метод который сравнивает строку из аргуметна и IgnoreCase(arg predicate)
     * Используется Predicate
     */
    @Test
    public void testIgnoreCaseLambda(){
        assertTrue(stringPredicateIgnoreCase("aaa").test("Aaa"));
        assertTrue(stringPredicateIgnoreCase("aaa").test("aaa"));
        assertTrue(stringPredicateIgnoreCase("aaa").test("AAA"));
    }

    private Predicate<String> stringPredicateIgnoreCase(String line){
        return line::equalsIgnoreCase;
//        return s -> line.equalsIgnoreCase(s);
    }

}
