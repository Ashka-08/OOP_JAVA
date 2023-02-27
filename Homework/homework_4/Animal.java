package Homework.homework_4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Animal implements Serializable, Comparable<Animal> {
    private String name;
    private Sex sex;
    private int birthYear;
    private Animal father;
    private Animal mother;
    private Animal partner;
    private List<Animal> children;

    public Animal(String name, Sex sex, int birthYear) {
        this(name, sex, birthYear, null, null, null);
    }

    public Animal(String name, Sex sex, int birthYear, 
    Animal father, Animal mother, Animal partner) {
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
    public List<Animal> addChild (Animal somebody) {
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
            for (Animal child : children) {
                System.out.println(child.getName() + " " + child.getBirthYear() + " г.р.");
            }
        }
        
    }

    @Override
    public String toString() {
        return String.format("%s, пол %s, %s г.р.", name, sex, birthYear);
    }
    
    @Override
    public int compareTo(Animal o) {
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

    public Animal getFather() {
        return father;
    }

    public void setFather(Animal father) {
        this.father = father;
    }

    public Animal getMother() {
        return mother;
    }

    public void setMother(Animal mother) {
        this.mother = mother;
    }

    public Animal getPartner() {
        return partner;
    }

    public void setPartner(Animal partner) {
        this.partner = partner;
    }
}
