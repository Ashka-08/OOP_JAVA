package Homework.homework_4;
import Homework.homework_4.model.GenealogicalTree;
import Homework.homework_4.model.Human;
import Homework.homework_4.model.Pet;
import Homework.homework_4.model.Sex;
import Homework.homework_4.model.Service.FileHandler;
import Homework.homework_4.model.Service.GenTreeService;
import Homework.homework_4.presenter.Presenter;
import Homework.homework_4.view.Console;
import Homework.homework_4.view.View;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileHandler<Human> fileHandler = new FileHandler<>();
        GenealogicalTree<Human> bigFamily = new GenealogicalTree<>(fileHandler);
        GenTreeService genTreeService = new GenTreeService(bigFamily);
        genTreeService.addIndividual("Федор", Sex.Man, 1947);
        genTreeService.addIndividual("Анна", Sex.Woman, 1949);
        genTreeService.addIndividual("Александр", Sex.Man, 1999);
        genTreeService.addIndividual("Мария", Sex.Man, 2003);
        genTreeService.addIndividual("Юрий", Sex.Man, 2022);
        genTreeService.addIndividual("Инна", Sex.Woman, 1999);
        
        genTreeService.searchGetHuman("Федор").addChild(
            genTreeService.searchGetHuman("Александр"));
        genTreeService.searchGetHuman("Федор").addChild(
            genTreeService.searchGetHuman("Мария"));
        genTreeService.searchGetHuman("Александр").addChild(
            genTreeService.searchGetHuman("Юрий"));
        
        FileHandler<Pet> petsFileHandler = new FileHandler<>();
        GenealogicalTree<Pet> pets = new GenealogicalTree<>(petsFileHandler);
        pets.addIndividual(new Pet(0, "Кошка", Sex.Woman, 2016));
        pets.addIndividual(new Pet(1, "Собака", Sex.Man, 2019));
        System.out.println("Питомцы:");
        pets.printGenTree();
        System.out.println("-------");
        
        Scanner iScanner = new Scanner(System.in, "Cp866");
        View view = new Console(iScanner);
        Presenter<Human> presenter = new Presenter(view, genTreeService, fileHandler);

        view.start();
    }
}
