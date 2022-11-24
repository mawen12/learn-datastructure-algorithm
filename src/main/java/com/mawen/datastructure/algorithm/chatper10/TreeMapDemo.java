package com.mawen.datastructure.algorithm.chatper10;

import java.util.*;

/**
 * TreeMap 是一个集合，但并不实现 Collection 接口
 * TreeMap 是一个实现了 red-black 树数据结构
 * 查找、插入、删除的最差时间为O(log(N))
 */
public class TreeMapDemo {

    public static void main(String[] args) {
//        baseUse();
        compare();
    }

    private static void baseUse() {
        TreeMap<Integer, String> persons = new TreeMap<>();
        System.out.println(persons.put(888, "Kalsi, Navdeep"));
        System.out.println(persons.put(222, "Johnson, Alan"));
        System.out.println(persons.put(123, "Bleaux, Joe"));
        System.out.println(persons.put(999, "Johnson, Alan"));
        System.out.println(persons.put(123, "Builder, Jay"));
        System.out.println(persons.containsKey(222));
        System.out.println(persons.containsValue("Bleaux, Joe"));
        System.out.println(persons.remove(999));
        System.out.println(persons.remove(11111));

        // 获取迭代器 Set
        Iterator<Map.Entry<Integer, String>> itr = persons.entrySet().iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        // 获取值聚集 Collection
        Iterator<String> iterator = persons.values().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void compare() {
        TreeMap<Integer, String> sort = new TreeMap<>(new Decreasing());
        sort.put(5, "");
        sort.put(7, "");

        System.out.println(sort);
    }

    /**
     * 倒序排列
     */
    static class Decreasing implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            return ((Integer) o2).compareTo((Integer) o1);
        }
    }

}
