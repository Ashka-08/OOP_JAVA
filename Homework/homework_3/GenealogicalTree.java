package Homework.homework_3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.IOException;
import java.io.Serializable;

import Homework.homework_3.Service.FileHandler;
import Homework.homework_3.Service.GenTreeIterator;
import Homework.homework_3.Service.Writable;

public class GenealogicalTree implements Serializable, Iterable<Human> {
    private List<Human> allPeople;
    private Writable writable;

    public GenealogicalTree(Writable writable) {
        allPeople = new ArrayList<>();
        this.writable = writable;
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
                return human;
            } 
        }
        return null;
    }

    /**
     * Метод печати всех человек из генеалогического древа
     */
    public void printGenTree() {
        for (Human human : allPeople) {
            System.out.println(human);
        }
    }

    public List<Human> getAllPeople() {
        return allPeople;
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public GenealogicalTree readFamilyTree() throws ClassNotFoundException, IOException {

        if (writable != null) {
            if (writable instanceof FileHandler) {

                if (writable.read() == null) {

                    System.out.println("FamilyTree в файле нет! Создаём новое FamilyTree.");
                    return new GenealogicalTree(writable);
                } else {
                    System.out.println("FamilyTree загружено из файла.");
                    return (GenealogicalTree) writable.read();
                }
            }
        } else {
            System.out.println("Файл не загружен!");
            return null;
        }
        return null;
    }

    @Override
    public Iterator<Human> iterator() {
        return new GenTreeIterator(allPeople);
    }
}
