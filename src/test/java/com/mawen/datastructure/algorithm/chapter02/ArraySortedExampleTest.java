package com.mawen.datastructure.algorithm.chapter02;

import org.junit.Assert;
import org.junit.Test;

public class ArraySortedExampleTest {

    @Test
    public void checkIsOrder() {
        int[] array = {1,2,3,4,5};
        int ret = ArraySortedExample.isArrayInSortedOrder(array, array.length);
        Assert.assertEquals(ret, 1);
    }

    @Test
    public void checkIsNotOrder() {
        int[] array = {1,3,2};
        int ret = ArraySortedExample.isArrayInSortedOrder(array, array.length);
        Assert.assertEquals(ret, 0);
    }
}