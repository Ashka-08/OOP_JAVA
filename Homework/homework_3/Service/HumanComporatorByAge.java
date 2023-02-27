package Homework.homework_3.Service;

import java.util.Comparator;

import Homework.homework_3.Human;

public class HumanComporatorByAge implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getBirthYear(), o2.getBirthYear());
    }
}