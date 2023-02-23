package Homework.Homework_2;

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler implements Writable {
    private Serializable serializable;

    @Override
    public void save(String path) {
        System.out.println("Сохраняем...");
        try {
            FileOutputStream outStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outStream);
            objectOutputStream.writeObject(serializable);
            outStream.close();
            objectOutputStream.close();
            System.out.println("Success");
        } catch (Exception e) {System.out.println("Error");}
    }

    @Override
    public GenealogicalTree read(String path) throws IOException {
        System.out.println("Восстановление после сериализации:");
        try {
            FileInputStream inStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(inStream);
            GenealogicalTree tempTree = (GenealogicalTree) objectInputStream.readObject();
            inStream.close();
            objectInputStream.close();
            return tempTree;
        } catch (ClassNotFoundException e) {
            System.out.println("-------error-----");
            return null;
        }
    }
}

