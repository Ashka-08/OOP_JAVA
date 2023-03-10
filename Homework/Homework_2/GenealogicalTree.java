package Homework.Homework_2;

import java.util.ArrayList;
import java.io.IOException;
import java.io.Serializable;


public class GenealogicalTree implements Serializable {
    private ArrayList<Human> allPeople;
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
        if (!allPeople.contains(somebody)) {
            allPeople.add(somebody);
            if (somebody.getFather() != null) {
                somebody.getFather().addChild(somebody);
            }
            if (somebody.getMother() != null) {
                somebody.getMother().addChild(somebody);
            }
        } 
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
        StringBuilder sb = new StringBuilder();
        for (Human human : allPeople) {
            sb.append("имя ");
            sb.append(human.getName());
            sb.append(", мать ");
            sb.append(human.getMother().getName());
            sb.append(", отец ");
            sb.append(human.getFather().getName());
            sb.append(", дети: ");
            sb.append(human.getChildrenInfo());
            System.out.println(sb);
        }
    }

    public ArrayList<Human> getAllPeople() {
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
}
