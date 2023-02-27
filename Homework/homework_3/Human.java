package Homework.homework_3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human> {
    private int id;
    private String name;
    private Sex sex;
    private int birthYear;
    private Human father;
    private Human mother;
    private Human partner;
    private List<Human> children;

    public Human(int id, String name, Sex sex, int birthYear) {
        this(id, name, sex, birthYear, null, null, null);
    }

    public Human(int id, String name, Sex sex, int birthYear, 
        Human father, Human mother, Human partner) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthYear = birthYear;
        this.father = father;
        this.mother = mother;
        this.partner = partner;
        this.children = new ArrayList<>();
    }

    /**
     * * Метод добавления ребенка к человеку.
     * @param somebody Ребенок, которого нужно добавить.
     * @param children Список детей человека
     */
    public List<Human> addChild (Human somebody) {
        this.children.add(somebody);
        return children;
    }

    /**
     * Метод вывода всех детей указанного человека
     */
    public void getChildren() {
        if (children.size() == 0) {
            System.out.printf("%s не имеет детей", name);
        } else {
            System.out.printf("%s имеет детей:\n", name);
            for (Human child : children) {
                System.out.println(child.getName() + " " + child.getBirthYear() + " г.р.");
            }
        }
        
    }

    @Override
    public String toString() {
        return String.format("id %d, %s, пол %s, %s г.р.", id, name, sex, birthYear);
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getPartner() {
        return partner;
    }

    public void setPartner(Human partner) {
        this.partner = partner;
    }
}
