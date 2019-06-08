package part1.lesson12.task01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Приложение создающее ошибку OutOfMemoryError с пометкой JavaHeapSpace.
 *
 * @author Овчинников Евгений
 */
public class OutOfMemoryErrorJavaHeapSpaceExample {

    public static void main(String[] args) throws InterruptedException {
        List<Object> listOfObjects = new ArrayList<>();
        while (true) {
            listOfObjects.add(new Object());
            new HashMap<String, Object>();
        }
    }
}
