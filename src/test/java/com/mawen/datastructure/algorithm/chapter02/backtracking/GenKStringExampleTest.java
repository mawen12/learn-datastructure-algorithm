package com.mawen.datastructure.algorithm.chapter02.backtracking;

import org.junit.Test;

public class GenKStringExampleTest {

    @Test
    public void kString() {
        int[] arr = {1, 2, 3};
        GenKStringExample example = new GenKStringExample(arr);
        example.kString(arr.length, 10);
    }

}