package word;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class WordProccessing {
  private String[] words;

  public WordProccessing(String[] words) {
    this.words = words;
  }

  public Word findTheFrequencyOfWord() {
    Map<String, Integer> map = new HashMap<String, Integer>();
    for (int i = 0; i < words.length; i++) {
      boolean keyExist = map.containsKey(words[i]);
      if (!keyExist) {
        map.put(words[i], 1);
      } else {
        map.put(words[i], map.get(words[i]) + 1);
      }
    }
    return new Word(map);
  }

  public Character findTheMostFrequencyLetter() {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0; i < words.length; i++) {
      char[] word = words[i].toCharArray();
      for (int j = 0; j < word.length; j++) {
        boolean keyExists = map.containsKey(word[j]);
        if (!keyExists) {
          map.put(word[j], 1);
        } else {
          map.put(word[j], map.get(word[j]) + 1);
        }
      }
    }
    Integer[] keys = map.values().toArray(new Integer[]{});
    Arrays.sort(keys);
    int max = keys[keys.length - 1];
    for (Character each : map.keySet()) {
      if (max == map.get(each)) {
        return each;
      }
    }
    return null;
  }
}


