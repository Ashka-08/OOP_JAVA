package Homework.homework_4;
import Homework.homework_4.Service.FileHandler;
import Homework.homework_4.Service.GenTreeIterator;
import Homework.homework_4.Service.IndividualComporatorByAge;
import Homework.homework_4.Service.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.io.IOException;
import java.io.Serializable;

public class GenealogicalTree<T extends Animal> implements Serializable, Iterable<T> {
    private List<T> allListTree;
    private Writable<T> writable;

    public GenealogicalTree(Writable<T> writable) {
        allListTree = new ArrayList<>();
        this.writable = writable;
    }

    /**
     * Метод добавления человека в генеалогическое древо
     * @param somebody человек, которого нужно добавить.
     */
    public void addIndividual(T somebody) {
        allListTree.add(somebody);
    }

    public void addIndividual(String string, Sex man, int i) {
    }
    
    /**
     * Метод поиска человека по имени и его детей
     * @param searchName принимает введенное пользователем значение 
     */
    public T searchPeople (String searchName) {
        for (T individual : allListTree) {
            if (individual.getName().equals(searchName)) {
                return individual;
            } 
        }
        return null;
    }

    /**
     * Метод печати всех человек из генеалогического древа
     */
    public void printGenTree() {
        for (T individual : allListTree) {
            System.out.println(individual);
        }
    }

    public void sortByName() { 
        Collections.sort(allListTree);
    }

    public void sortByAge() {
        Collections.sort(allListTree, new IndividualComporatorByAge<T>());        
    }
    
    public List<T> getAllListTree() {
        return allListTree;
    }

    public void setWritable(Writable<T> writable) {
        this.writable = writable;
    }

    public GenealogicalTree<T> readFamilyTree() 
        throws ClassNotFoundException, IOException {
        if (writable != null) {
            if (writable instanceof FileHandler) {
                if (writable.read() == null) {
                    System.out.println("FamilyTree в файле нет! Создаём новое FamilyTree.");
                    return new GenealogicalTree<T>(writable);
                } else {
                    System.out.println("FamilyTree загружено из файла.");
                    return (GenealogicalTree<T>) writable.read();
                }
            }
        } else {
            System.out.println("Файл не загружен!");
            return null;
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new GenTreeIterator<T>(allListTree);
    }
}
