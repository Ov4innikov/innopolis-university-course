package part1.lesson08.task01and02;

import java.io.*;
import java.time.Instant;

/**
 * Класс для сериализации и десериализации обьектов в файл и из файла.
 *
 * @autor Овчинников Евгений
 */
public class Serializer {

    /**
     * Метод для сериализации обьекта в файл
     *
     * @param o    - сериализуемый обьект, должен имплементировать интерфейс метку Serializabel.
     * @param path - путь к файлу для сохраниения сериализованного обьекта.
     */
    public static void serialize(Object o, String path) throws IOException {
        File file = new File(path);
        file.createNewFile();
        try (FileOutputStream fileOutputStream = new FileOutputStream(file); ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(o);
        }
    }

    /**
     * Метод для сериализации обьекта в файл
     *
     * @param path - файл для чтения сериализованного обьекта
     * @return десериализованный обьект
     */
    public static Object deSerialize(String path) throws IOException, ClassNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream(path); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
            return objectInputStream.readObject();
        }
    }
}
