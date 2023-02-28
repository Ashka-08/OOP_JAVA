package Homework.homework_4.model.Service;

import java.io.Serializable;

public interface Writable<T> {
    void save(Serializable serializable);
    Object read();
}
