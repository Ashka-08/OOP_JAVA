package Homework.homework_4.Service;
import Homework.homework_4.Animal;
import Homework.homework_4.GenealogicalTree;
import Homework.homework_4.Human;
import Homework.homework_4.Sex;

import java.util.Collections;

public class GenTreeService<T extends Animal> {
    private GenealogicalTree<T> genealogicalTree;
    private static int idIndividual;

    public GenTreeService(GenealogicalTree<T> genealogicalTree) {
        this.genealogicalTree = genealogicalTree;
        idIndividual = 0;
    }

    public void addIndividual(String name, Sex sex, int birthYear){
        T individual = new T (idIndividual++, name, sex, birthYear);
        genealogicalTree.addIndividual(individual);
    }

    public void sortByName(GenealogicalTree<T> genealogicalTree) { 
        Collections.sort(genealogicalTree.getAllListTree());
    }

    public void sortByAge() {
        Collections.sort(genealogicalTree.getAllListTree(), new IndividualComporatorByAge<T>());        
    }
}
    
