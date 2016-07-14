package page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class PageBean {
  private List<String> listOfPages;
  private List<String> result;
  private int pageSize;
  int page;
  int index;


  public PageBean(List<String> listOfPages, int pageSize) {
    this.listOfPages = listOfPages;
    this.pageSize = pageSize;
    page = 0;
  }

  public Page next() throws PageNotFoundException {
    if (hasNext()) {
      if (page % 2 != 0) {
        pageSize++;
      } else {
        pageSize--;
      }
      result = listOfPages.subList(index, index + pageSize);
      index += pageSize;
      ++page;
    } else {
      throw new PageNotFoundException("Error");
    }
    return new Page(result, getCurrentPageNumber());
  }

  public Page previous() throws PageNotFoundException {
    if (hasPrevious()) {
      if (page % 2 != 0) {
        pageSize++;
        index++;
      } else {
        pageSize--;
        index--;
      }
      --page;
      index -= pageSize;
      result = listOfPages.subList(index - pageSize, index);
    } else {
      throw new PageNotFoundException("Page not found!");
    }
    return new Page(result, getCurrentPageNumber());
  }

  public Page firstPage() {
    index = 0;
    result = listOfPages.subList(index, index + pageSize);
    page = 1;
    return new Page(result, getCurrentPageNumber());
  }

  public Page lastPage() {
    index = listOfPages.size();
    result = new ArrayList<String>(listOfPages.subList(index - pageSize, index));
    page = listOfPages.size() / pageSize;
    return new Page(result, getCurrentPageNumber());
  }

  public boolean hasNext() {
    if (index <= listOfPages.size()) {
      return true;
    } else return false;
  }

  public boolean hasPrevious() {
    if (index > 0) {
      return true;
    }
    return false;
  }

  public int getCurrentPageNumber() {
    return page;
  }
}



