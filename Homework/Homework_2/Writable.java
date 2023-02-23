package Homework.Homework_2;

import java.io.Serializable;

public interface Writable {
    void save(Serializable serializable);
    GenealogicalTree read();
}
