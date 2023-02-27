package Homework.homework_3.Service;

import java.io.Serializable;

import Homework.homework_3.GenealogicalTree;

public interface Writable {
    void save(Serializable serializable);
    GenealogicalTree read();
}
