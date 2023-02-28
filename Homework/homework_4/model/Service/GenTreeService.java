package Homework.homework_4.model.Service;
import java.io.Serializable;
import java.util.Collections;

import Homework.homework_4.model.GenealogicalTree;
import Homework.homework_4.model.Human;
import Homework.homework_4.model.Sex;

public class GenTreeService implements Serializable {
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

    public void sortByName() { 
        Collections.sort(genealogicalTree.getAllListTree());
    }

    public void sortByAge() {
        Collections.sort(genealogicalTree.getAllListTree(), 
            new IndividualComporatorByAge<Human>());        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Human human : genealogicalTree) {
            sb.append(human.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String search(String nameSearch) {
        return genealogicalTree.searchForName(nameSearch);
    }

    public Human searchGetHuman (String nameSearch) {
        return genealogicalTree.searchGetHuman(nameSearch);
    }
}
    
