package com.cloway.guava.sentences;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Demo {
  public static void main(String[] args) {
    Sentence sentence = new Sentence();
    String string = "I see what I want to see";
    System.out.println("word frequency for: \"" + string + "\" is ");
    System.out.println(sentence.wordFrequency(string));
    System.out.println("the most frequently occurring character is: " + sentence.mostFrequentChar(string));
  }
}
