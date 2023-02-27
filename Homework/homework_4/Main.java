package Homework.homework_4;
import Homework.homework_4.Service.FileHandler;
import Homework.homework_4.Service.GenTreeService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileHandler<Human> fileHandler = new FileHandler<>();
        GenealogicalTree<Human> bigFamily = new GenealogicalTree<>(fileHandler);
        GenTreeService<Human> genTreeService = new GenTreeService<>(bigFamily);
        genTreeService.addIndividual("Федор", Sex.Man, 1947);
        genTreeService.addIndividual("Анна", Sex.Woman, 1949);
        genTreeService.addIndividual("Александр", Sex.Man, 1999);
        genTreeService.addIndividual("Мария", Sex.Man, 2003);
        genTreeService.addIndividual("Юрий", Sex.Man, 2022);
        genTreeService.addIndividual("Инна", Sex.Woman, 1999);
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
