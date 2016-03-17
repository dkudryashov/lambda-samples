
package com.dkudryashov.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by d.kudryashov on 11.03.2016.
 */
public class ForeachTest {

    /**
     * Прохлод и вывод чисел из масива которые больше 2
     */
    @Test
    public void testFilterDefault(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> moreFirstList = new ArrayList<>(Arrays.asList(3, 4, 5, 6));
        List<Integer> moreSecondList = new ArrayList<>();
        for (Integer integer : list) {
            if (integer > 2){
                moreSecondList.add(integer);
            }
        }
        assertArrayEquals(moreFirstList.toArray(), moreSecondList.toArray());
    }

    /**
     * Прохлод и вывод чисел из масива которые больше 2
     * Используя lambda и stream
     */
    @Test
    public void testFilterLambda(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> moreFirstList = new ArrayList<>(Arrays.asList(3, 4, 5, 6));
        List<Integer> moreSecondList = new ArrayList<>();
        list.stream().filter(x -> x > 2).forEach(moreSecondList::add);
        assertArrayEquals(moreFirstList.toArray(), moreSecondList.toArray());

    }


}
