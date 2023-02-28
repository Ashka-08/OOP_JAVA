package Homework.homework_4.model.Service;
import Homework.homework_4.model.Animal;
import Homework.homework_4.model.GenealogicalTree;

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler<T extends Animal> implements Writable<T>, Serializable {
    private String fileName;
    private static final long serialVersionUID = 1;

    public FileHandler() {
        this.fileName = "GenealogicalTree.out";
    }

    public void setFilename(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Сериализация в файл с помощью класса ObjectOutputStream
     */
    @Override
    public void save(Serializable serializable) {
        System.out.println("Сохраняем...");
        try {
            FileOutputStream outStream = new FileOutputStream("GenealogicalTree.out", true);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outStream);
            objectOutputStream.writeObject(serializable);
            outStream.close();
            objectOutputStream.close();
            System.out.printf("Cохранено в файл %s\n", fileName);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * // Востановление из файла с помощью класса ObjectInputStream
     */
    @Override
    public Serializable read() {
        System.out.println("Восстановление после сериализации...");
        try {
            FileInputStream inStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(inStream);
            Serializable tempTree = (Serializable) objectInputStream.readObject();
            inStream.close();
            objectInputStream.close();
            System.out.println("Успешно!");
            return tempTree;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}