package com.mawen.datastructure.algorithm.chatper10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ThesaurusDriver {

    Thesaurus thesaurus;

    boolean readingInFileName;

    public ThesaurusDriver() {
        final String IN_FILE_PROMPT = "Please enter the path for the input file.";
        thesaurus = new Thesaurus();
        readingInFileName = true;
        System.out.println(IN_FILE_PROMPT);
    }

    public void processInput(String s) {
        final String WORD_PROMPT = "\n\nPlease enter a word, The sentinel is ";
        final String SENTINEL = "***";
        final String WORD_NOT_FOUND_MESSAGE = "That word does not appear in the thesaurus";
        final String SYNONYMS_MESSAGE = "The synonyms of that word are ";
        final String CLOSE_WINDOW_MESSAGE = "\n\nThe execution of the project is complete. Please close this window when you are ready.";

        LinkedList synonymList;
        if (readingInFileName) {
            if (thesaurusWasConstructed(s)) {
                readingInFileName = false;
                System.out.println(WORD_PROMPT + SENTINEL);
            }
        } else if (!s.equals(SENTINEL)) {
            synonymList = thesaurus.getSynonyms(s);
            if (synonymList == null) {
                System.out.println(WORD_NOT_FOUND_MESSAGE);
            } else {
                System.out.println(SYNONYMS_MESSAGE + synonymList);
                System.out.println(WORD_PROMPT + SENTINEL);
            }
        } else {
            System.out.println(CLOSE_WINDOW_MESSAGE);
        }
    }

    /**
     * 判断词库构建是否已完成
     * @param inFileName
     * @return
     */
    protected boolean thesaurusWasConstructed(String inFileName) {
        final String NO_INPUT_FILE_FOUND_MESSAGE = "Error: there is no file with that path. \n\n";
        final String ERROR_MESSAGE = "Exception:";
        BufferedReader inFile;
        String line;
        boolean success = false;
        try {
            inFile = new BufferedReader(new FileReader(inFileName));
            success = true;
            while ((line = inFile.readLine()) != null) {
                thesaurus.add(line);
            }
            inFile.close();
        } catch (IOException e) {
            System.out.println(ERROR_MESSAGE + e);
        }
        return success;
    }
}
