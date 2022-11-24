package com.mawen.datastructure.algorithm.chatper10;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {
        Set<Person> persons = new TreeSet<>();
        persons.add(new Person(1L, "Jack"));
        persons.add(new Person(2L, "Rose"));

        System.out.println(persons);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Person {
        private Long id;
        private String name;
    }
}
