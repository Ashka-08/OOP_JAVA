package Homework.homework_3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import Homework.homework_3.Service.FileHandler;
import Homework.homework_3.Service.GenTreeService;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileHandler fileHandler = new FileHandler();
        GenealogicalTree bigFamily = new GenealogicalTree(fileHandler);
        GenTreeService genTreeService = new GenTreeService(bigFamily);
        genTreeService.addHuman("Федор", Sex.Man, 1947);
        genTreeService.addHuman("Анна", Sex.Woman, 1949);
        genTreeService.addHuman("Александр", Sex.Man, 1999);
        genTreeService.addHuman("Мария", Sex.Man, 2003);
        genTreeService.addHuman("Юрий", Sex.Man, 2022);
        genTreeService.addHuman("Инна", Sex.Woman, 1999);
        // bigFamily.printGenTree();
        for (Human human : bigFamily) {
            System.out.println(human);
        }
        System.out.println("-------");
        
        genTreeService.sortByAge();
        System.out.println("Сортировка по году рождения");
        for (Human human : bigFamily) {
            System.out.println(human);
        }
        System.out.println("-------");

        genTreeService.sortByName(bigFamily);
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

    public static void searchChild(Scanner iScanner, GenealogicalTree bigFamily) {
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
