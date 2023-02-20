package Homework.homework_1;

import java.util.ArrayList;

public class GenealogicalTree {
    private ArrayList<Human> allPeople;

    public GenealogicalTree() {
        allPeople = new ArrayList<>();
    }

    /**
     * Метод добавления человека в генеалогическое древо
     * @param somebody человек, которого нужно добавить.
     */
    public void addHuman(Human somebody) {
        allPeople.add(somebody);
    }

    /**
     * Метод поиска человека по имени и его детей
     * @param searchName принимает введенное пользователем значение 
     */
    public Human searchPeople (String searchName) {
        for (Human human : allPeople) {
            if (human.getName().equals(searchName)) {
                System.out.printf("Результат поиска: %s\n", human.getName());
                return human;
            } 
        }
        return null;
    }
    // тоже не работает
    // public void searchPeople (String searchName) {
    //     for (Human human : allPeople) {
    //         if (!human.getName().equalsIgnoreCase(searchName)) {
    //             System.out.println("Совпадений не найдено");
    //         } else {
    //             System.out.printf("Результат поиска: %s\n", human.getName());
    //             human.getChildren();
    //         }
    //     }
    // }

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
