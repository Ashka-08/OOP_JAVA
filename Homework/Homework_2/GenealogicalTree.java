package Homework.Homework_2;

import java.util.ArrayList;
import java.io.IOException;
import java.io.Serializable;


public class GenealogicalTree implements Serializable, Writable{
    private ArrayList<Human> allPeople;
    private Writable writable;
    private static final long serialVersionUID = 1L;

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

    public ArrayList<Human> getAllPeople() {
        return allPeople;
    }

    @Override
    public void save(String path) {
        if (writable instanceof FileHandler) {
            FileHandler fileHandler = (FileHandler) writable;
            fileHandler.save(path);
        }
        if (writable != null){
            writable.save("database.xml");
        }  
    }

    @Override
    public Object read(String path) throws IOException {
        if (writable instanceof FileHandler) {
            FileHandler fileHandler = (FileHandler) writable;
            return fileHandler.read(path);
        }
        if (writable != null){
            writable.read("database.xml");
        }
        return null;
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }
}
