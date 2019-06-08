package part1.lesson12.task02;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * Приложения для генирации ошибки OutOfMemoryError с пометкой Metaspace.
 * Что бы быстрей воспроизвести ошибку необходимо установить параметр "-XX:MaxMetaspaceSize=".
 *
 * @author Овчинников Евгений
 */
public class OutOfMemoryErrorMetaspaceExample {

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        System.out.println("Start!");
        List<Class> list = new ArrayList<Class>();
        while (true) {
            list.add(new MyClassLoader().loadClass("part1.lesson09.task01.DynamicWorker"));
        }
    }
}
