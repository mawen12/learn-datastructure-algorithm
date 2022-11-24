package com.mawen.datastructure.algorithm.chatper10;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SpellChecker {
    private TreeSet<String> words;
    private TreeSet<String> dictionary;

    public SpellChecker() {
        words = new TreeSet<>();
        dictionary = new TreeSet<>();
    }

    public void addToDictionary(String word) {
        dictionary.add(word);
    }

    public void addToWordSet(String line) {
        final String DELIMITERS = "\n\r\t;:.!?( )";
        StringTokenizer tokens = new StringTokenizer(line, DELIMITERS);
        String word;
        while (tokens.hasMoreTokens()) {
            word = tokens.nextToken().toLowerCase();
            words.add(word);
        }
    }

    public LinkedList<String> compare() {
        LinkedList<String> misspelled = new LinkedList<>();
        String word;
        Iterator<String> itr = words.iterator();
        while (itr.hasNext()) {
            word = itr.next();
            if (!dictionary.contains(word)) {
                misspelled.add(word);
            }
        }
        return misspelled;
    }
}
