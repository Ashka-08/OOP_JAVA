package Homework.homework_1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Human human1 = new Human("Федор");
        Human human2 = new Human();
        Human human3 = new Human("Александр", Sex.Man, "16.07.1999");
        Human human4 = new Human("Мария", Sex.Man, "19.11.2003");
        Human human5 = new Human("Юрий", Sex.Man, "17.02.2022");
        Human human6 = new Human("Инна", Sex.Woman, "16.08.1999");

        GenealogicalTree bigFamily = new GenealogicalTree();
        bigFamily.addHuman(human1);
        bigFamily.addHuman(human2);
        bigFamily.addHuman(human3);
        bigFamily.addHuman(human4);
        bigFamily.addHuman(human5);
        bigFamily.addHuman(human6);
        bigFamily.printGenTree();
        System.out.println("-------");
        
        human5.setMother(human6);
        System.out.printf("У матери человека, которого зовут %s, имя %s", 
            human5.getName(), human5.getMother().getName());
        System.out.println("\n-------");

        human1.setPartner(human2);
        human2.setPartner(human1);
        System.out.println(human2.getPartner());
        human1.addChild(human3);
        human1.addChild(human4);
        human1.getChildren();
        System.out.println("-------");

        human3.setPartner(human6);
        human3.addChild(human5);        
        human3.getChildren();

        System.out.println("-------");
        Scanner iScanner = new Scanner(System.in, "Cp866");
        System.out.print("Введите имя для поиска: ");
        String searchName = iScanner.next();
        iScanner.close();

        if (bigFamily.searchPeople(searchName) == null) {
            System.out.println("Совпадений не найдено");
        } else {
            System.out.printf("Результат поиска: %s найден\n", bigFamily.searchPeople(searchName).getName());
            bigFamily.searchPeople(searchName).getChildren();
        }
    }   
}