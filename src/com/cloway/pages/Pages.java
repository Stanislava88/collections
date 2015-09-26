package com.cloway.pages;


import java.util.ArrayList;
import java.util.List;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Pages {
    private int pageSize;
    private int firstElement;
    private int lastElement;
    private final List<String> list;
    private List<String> listError = new ArrayList<>();

    public Pages(List<String> list, int pageSize) {
        this.pageSize = pageSize;
        firstElement = 0 - pageSize;
        lastElement = firstElement + pageSize;
        this.list = new ArrayList<>(list);
    }

    public List<String> next() {
        int c = hasNext();

        if (c >= pageSize) {
            firstElement += pageSize;
            lastElement += pageSize;
            return list.subList(firstElement, lastElement);
        }
        if (c > 0 && c < pageSize) {
            firstElement += pageSize;
            lastElement += c;
            return list.subList(firstElement, lastElement);
        }

        listError.clear();
        listError.add("Sorry, reached the last page");
        return listError;

    }

    public List<String> previous() {
        if (lastElement - firstElement < pageSize) {
            firstElement -= pageSize;
            lastElement = firstElement + pageSize;
            return list.subList(firstElement, lastElement);
        }
        if (hasPrevious()) {
            firstElement -= pageSize;
            lastElement -= pageSize;
            return list.subList(firstElement, lastElement);
        } else {
            listError.clear();
            listError.add("sorry you are at the first page");
            return listError;
        }
    }

    public int hasNext() {
        return lastElement < list.size() ? list.size() - lastElement : 0;
    }

    public boolean hasPrevious() {
        return firstElement - pageSize >= 0;
    }

    public List<String> firstPage() {
        firstElement = 0;
        lastElement = firstElement + pageSize;
        return list.subList(firstElement, lastElement);
    }

    public List<String> lastPage() {
        lastElement = list.size();
        firstElement = lastElement - pageSize;
        return list.subList(firstElement, lastElement);
    }
}
