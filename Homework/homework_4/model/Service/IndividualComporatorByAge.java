package Homework.homework_4.model.Service;
import Homework.homework_4.model.Animal;

import java.util.Comparator;

public class IndividualComporatorByAge<T extends Animal> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getBirthYear(), o2.getBirthYear());
    }
}