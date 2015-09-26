package com.cloway.sentences;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Sentence {

    /**
     * Compiles a HashMap of how much times each word occurs in a string
     *
     * @param sentence the string which to process
     * @return a HashMap of the number of occurrences of each word in a string
     */
    public Map<String, Integer> wordFrequency(String sentence) {
        String[] sentenceArray = sentence.split(" ");
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        for (String word : sentenceArray) {

            if (map.containsKey(word)) {

                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        return map;
    }

    /**
     * Retern's the most common character for a string
     *
     * @param sentence from which to search for the most frequent character
     * @return a Map with one element which is the character most frequently occurring in a string
     */
    public Map<Character, Integer> charMostFrequent(String sentence) {
        char[] ch = sentence.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char theChar = ',';
        int numberOfOccurrences = 0;
        for (char c : ch) {
            if (map.containsKey(c)) {
                int value = map.get(c) + 1;
                map.put(c, value);
                if (c > numberOfOccurrences) {
                    numberOfOccurrences = value;
                    theChar = c;
                }
            } else {
                map.put(c, 1);
            }
        }
        Map<Character, Integer> returnMap = new HashMap<Character, Integer>(1);
        returnMap.put(theChar, numberOfOccurrences);
        return returnMap;
    }
}
