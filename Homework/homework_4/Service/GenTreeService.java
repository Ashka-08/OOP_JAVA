package Homework.homework_4.Service;
import Homework.homework_4.Animal;
import Homework.homework_4.GenealogicalTree;
import Homework.homework_4.Human;
import Homework.homework_4.Sex;

import java.util.Collections;

public class GenTreeService {
    private GenealogicalTree<Human> genealogicalTree;
    private static int idIndividual;

    public GenTreeService(GenealogicalTree<Human> genealogicalTree) {
        this.genealogicalTree = genealogicalTree;
        idIndividual = 0;
    }

    public void addIndividual(String name, Sex sex, int birthYear){
        Human individual = new Human(idIndividual++, name, sex, birthYear);
        genealogicalTree.addIndividual(individual);
    }

    public void sortByName(GenealogicalTree<Human> genealogicalTree) { 
        Collections.sort(genealogicalTree.getAllListTree());
    }

    public void sortByAge() {
        Collections.sort(genealogicalTree.getAllListTree(), 
            new IndividualComporatorByAge<Human>());        
    }
}
    
