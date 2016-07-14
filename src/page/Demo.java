package page;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class Demo {
  public static void main(String[] args) throws PageNotFoundException {
    try {
      List<String> list = new ArrayList<String>();
      list.add("Maria");
      list.add("Ivan");
      list.add("77");
      list.add("68");
      list.add("Ivan");
      list.add("77");
      list.add("Lilia");
      list.add("85");
      list.add("Martin");
      list.add("55");
      list.add("Ivan");
      list.add("95");
      PageBean page = new PageBean(list, 2);
      System.out.println(page.next());
      System.out.println(page.next());
      System.out.println(page.previous());
      System.out.println(page.firstPage());
      System.out.println("For next page press 1: " + "\n" + "For previous page press 2:");
      System.out.println("For first page press 3:" + "\n" + "For last page press 4:");
      Scanner scanner = new Scanner(System.in);
      int options = scanner.nextInt();
      switch (options) {
        case 1:
          try {
            System.out.println("Next page:");
            System.out.println(page.next());
            break;
          } catch (IndexOutOfBoundsException ex) {
            System.out.println("This is last page");
          }
        case 2:
          try {
            System.out.println("Previous page:");
            System.out.println(page.previous());
            break;
          } catch (IndexOutOfBoundsException ex) {
            System.out.println("This is first page! Don't have previous.");
          }
        case 3:
          System.out.println("First page:");
          System.out.println(page.firstPage());
          break;
        case 4:
          System.out.println("Last page:");
          System.out.println(page.lastPage());
          break;
        default:
          System.out.println("Invalid case. ");
          break;
      }
    } catch (InputMismatchException ex) {
      System.out.println("Invalid input. Please enter number!");
    } catch (PageNotFoundException error) {
      System.out.println(error.getMessage());
    } catch (IndexOutOfBoundsException ex) {
      ex.getStackTrace();
    }
  }
}

