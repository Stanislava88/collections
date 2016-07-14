package page;

import java.util.List;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class Page {
  private List<String> page;
  private int numberOfPage;

  public Page(List<String> page, int numberOfPage) {
    this.page = page;
    this.numberOfPage = numberOfPage;
  }

  public String toString() {
    return "PageContent:" + page +
            " " + "Number of page is:" + numberOfPage;
  }
}


