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
   * Counts how much times each word occurs in a string
   *
   * @param sentence the string which to process
   * @return a map with the words as  keys and the number of occurrences as a value
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
   * Returns the most common character for a string
   *
   * @param sentence from which to search for the most frequent character
   * @return a map with the character as a key and the number of occurrences as a value
   */
  public Map<Character, Integer> mostFrequentCharacter(String sentence) {
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
