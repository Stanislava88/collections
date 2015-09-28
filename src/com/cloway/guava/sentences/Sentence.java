package com.cloway.guava.sentences;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

import java.util.Arrays;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Sentence {
  /**
   * Counts the number of times each word occurs in a sentence
   *
   * @param sentence to be processed
   * @return a multimap with a word for key and integer for the count of that word
   */
  public Multimap wordFrequency(String sentence) {
    String[] sentenceWords = sentence.split(" ");
    Multiset<String> words = HashMultiset.create();
    Multimap<String, Integer> freq = HashMultimap.create();
    words.addAll(Arrays.asList(sentenceWords));
    for (String word : words.elementSet()) {
      freq.put(word, words.count(word));
    }
    return freq;
  }

  /**
   * Returns the most frequent character for a sentence
   *
   * @param sentence to be processed
   * @return a multimap with one key-value pair representing the character
   */
  public Multimap mostFrequentChar(String sentence) {
    char[] charsInSentence = sentence.toCharArray();
    Multiset<Character> chars = HashMultiset.create();
    for (char ch : charsInSentence) {
      chars.add(ch);
    }
    Multimap<Character, Integer> result = HashMultimap.create();
    Character theChar = '0';
    int numberOfTimes = 0;
    for (Character a : chars.elementSet()) {
      if (chars.count(a) > numberOfTimes && !a.equals(' ')) {
        numberOfTimes = chars.count(a);
        theChar = a;
      }
    }
    result.put(theChar, numberOfTimes);
    return result;
  }
}
