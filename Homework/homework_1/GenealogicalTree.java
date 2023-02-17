package Homework.homework_1;

import java.util.ArrayList;

public class GenealogicalTree {
    private ArrayList<Human> allPeople;

    public GenealogicalTree() {
        this.allPeople = new ArrayList<>();
    }

    /**
     * Метод добавления человека в генеалогическое древо
     * @param somebody человек, которого нужно добавить.
     */
    public void addHuman(Human somebody) {
        allPeople.add(somebody);
    }

    /**
     * Метод печати всех человек из генеалогического древа
     */
    public void printGenTree() {
        for (Human human : allPeople) {
            System.out.println(human);
        }
    }

    public ArrayList<Human> getAllPeople() {
        return allPeople;
    }
}
