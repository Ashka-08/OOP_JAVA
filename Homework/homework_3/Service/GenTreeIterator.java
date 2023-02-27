package Homework.homework_3.Service;

import java.util.Iterator;
import java.util.List;

import Homework.homework_3.Human;

public class GenTreeIterator implements Iterator<Human> {
    private List<Human> allPeople;
    private int index;

    public GenTreeIterator(List<Human> allPeople) {
        this.allPeople = allPeople;
    }

    @Override
    public boolean hasNext() {
        return index < allPeople.size();
    }

    @Override
    public Human next() {
        return allPeople.get(index++);
    }
}
