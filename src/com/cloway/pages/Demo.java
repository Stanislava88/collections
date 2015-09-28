package com.cloway.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Demo {

  public static void main(String[] args) {
    String[] str = {"s", "p", "m", "t", "r", "l", "z"};
    List<String> strings = new ArrayList<>(Arrays.asList(str));
    Pages page = new Pages(strings, 2);
    List<String> currentPage = page.next();

    Scanner scan = new Scanner(System.in);
    boolean stop = false;
    boolean unchanged = true;
    while (!stop) {

      if (unchanged) {
        for (Object o : currentPage) {
          System.out.println(o);
        }
      }
      String scanned = scan.nextLine();
      switch (scanned) {
        case "next":
          currentPage = page.next();
          unchanged = true;
          break;
        case "previous":
          currentPage = page.previous();
          unchanged = true;
          break;
        case "hasNext":
          if (page.hasNext() > 0) System.out.println("true");
          else System.out.println("false");
          unchanged = false;
          break;
        case "hasPrevious":
          System.out.println(page.hasPrevious());
          unchanged = false;
          break;
        case "firstPage":
          currentPage = page.firstPage();
          unchanged = true;
          break;
        case "lastPage":
          currentPage = page.lastPage();
          unchanged = true;
          break;
        case "stop":
          stop = true;
          break;
        default:
          System.out.println("sorry invalid entry ");
          unchanged = false;
          break;
      }
    }
  }
}
