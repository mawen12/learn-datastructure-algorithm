package com.mawen.datastructure.algorithm.chatper10;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 词典，接受输入，并打印近义词
 */
public class Thesaurus {

    TreeMap<String, LinkedList<String>> thesaurusMap;

    public Thesaurus() {
        this.thesaurusMap = new TreeMap();
    }

    public void add(String line) {
        LinkedList<String> synonymsList = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(line);
        String word = st.nextToken();
        while (st.hasMoreTokens()) {
            synonymsList.add(st.nextToken());
        }
        thesaurusMap.put(word, synonymsList);
    }

    /**
     * 返回指定单词的近义词
     * @param word 单词
     * @return 如果存在，则返回近义词
     */
    public LinkedList<String> getSynonyms(String word) {
        return thesaurusMap.get(word);
    }
}
