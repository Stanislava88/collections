package word;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class Word  {
  Map<String, Integer> word = new HashMap<String, Integer>();

  public Word(Map word) {
    this.word = word;
  }

  public String toString() {
    return "Word occurs:" + word;
  }
}
