package part1.lesson11.task01;

import part1.lesson11.task01.exception.DublicateNumberException;

/**
 * Приложение с методом main, для демонстрации работы Box-ов из 4 урока.
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class Application {

    public static void main(String[] args) {
        Object[] objects = new Object[]{"string", new Object(), new Integer(1), new Character((char) 55), new Character('a'), new Double(2)};
        ObjectBox objectBox = new ObjectBox<>();
        for (Object object : objects) {
            objectBox.addObject(object);
        }
        objectBox.dump();

        Number[] numbers = new Number[]{1, 3, 4L, 5, 1d, 2f, 2.0, (byte) 2, (short) 2};
        MathBox mathBox1 = null;
        MathBox<Number> mathBox2 = null;
        try {
            mathBox1 = new MathBox(numbers);
            mathBox2 = new MathBox<Number>(numbers);
        } catch (DublicateNumberException e) {
            System.err.println(e);
        }
        if (mathBox1 != null) mathBox1.dump();
        if (mathBox2 != null) mathBox2.dump();
        System.out.println("sum = " + mathBox1.summator());
        mathBox2.splitter(2);
        if (mathBox1 != null) mathBox1.dump();
        if (mathBox2 != null) mathBox2.dump();
    }
}
