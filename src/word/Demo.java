package word;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class Demo {
  public static void main(String[] args) {
    String[] text = {"aa", "bb", "cc", "dd", "aa", "bb", "cc", "bb", "cc", "cc"};
    WordProccessing wordProccessing = new WordProccessing(text);
    System.out.println(wordProccessing.findTheFrequencyOfWord());
    System.out.println(wordProccessing.findTheMostFrequencyLetter());
  }
}
