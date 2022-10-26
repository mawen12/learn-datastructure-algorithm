package com.mawen.datastructure.algorithm.chapter03.questions;

import org.junit.Test;

public class Question01Test {


    @Test
    public void testAdd() {
        Question01.StackExample stack = new Question01.StackExample(1);
        stack = stack.insertAtBeginInStack(stack, new Question01.StackExample(2));

        System.out.println(stack);
    }

}