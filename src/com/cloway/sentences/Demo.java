package com.cloway.sentences;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Demo {
    public static void main(String[] args) {
        String sentence = "I see what I want to see";
        Sentence s1 = new Sentence();
        System.out.println(s1.wordFrequency(sentence));
        System.out.println(s1.mostFrequentCharacter(sentence));
    }
}
