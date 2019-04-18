package part1.lesson02.task01;

/**
 * Класс решения первого задания.
 * @autor Овчинников Евгений
 * @version 1.0.0
 */
public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        throw new HelloWorldException();
    }
}
