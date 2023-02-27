package Homework.homework_4;
import Homework.homework_4.Service.FileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileHandler<Human> fileHandler = new FileHandler<>();
        GenealogicalTree<Human> bigFamily = new GenealogicalTree<>(fileHandler);
        
        Human human1 = new Human("Федор", Sex.Man, 1947);
        Human human2 = new Human("Анна", Sex.Woman, 1949);
        Human human3 = new Human("Александр", Sex.Man, 1999);
        Human human4 = new Human("Мария", Sex.Woman, 2003);
        Human human5 = new Human("Юрий", Sex.Man, 2022);
        Human human6 = new Human("Инна", Sex.Woman, 1999);

        bigFamily.addIndividual(human1);
        bigFamily.addIndividual(human2);
        bigFamily.addIndividual(human3);
        bigFamily.addIndividual(human4);
        bigFamily.addIndividual(human5);
        bigFamily.addIndividual(human6);

        // bigFamily.printGenTree();
        for (Human human : bigFamily) {
            System.out.println(human);
        }
        System.out.println("-------");
        
        bigFamily.sortByAge();
        System.out.println("Сортировка по году рождения");
        for (Human human : bigFamily) {
            System.out.println(human);
        }
        System.out.println("-------");

        bigFamily.sortByName();
        System.out.println("Сортировка по имени");
        for (Human human : bigFamily) {
            System.out.println(human);
        }

        // поиск по имени

        // Scanner iScanner = new Scanner(System.in, "Cp866");
        // searchChild(iScanner, bigFamily);
        // iScanner.close();
        
        // сериализация и десериализация

        // fileHandler.save(bigFamily);
        // fileHandler.read();
    }

    public static void searchChild(Scanner iScanner, GenealogicalTree<Human> bigFamily) {
        System.out.println("-------");
        System.out.print("Введите имя для поиска: ");
        String searchName = iScanner.next();
        if (bigFamily.searchPeople(searchName) == null) {
            System.out.println("Совпадений не найдено");
        } else {
            System.out.printf("Результат поиска: %s найден\n", bigFamily.searchPeople(searchName).getName());
            bigFamily.searchPeople(searchName).getChildren();
        }
        System.out.println("-------");
    }
}
