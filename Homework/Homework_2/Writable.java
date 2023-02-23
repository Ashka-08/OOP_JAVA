package Homework.Homework_2;

import java.io.IOException;

public interface Writable {
    void save(String Path);
    Object read(String path) throws IOException;
}
