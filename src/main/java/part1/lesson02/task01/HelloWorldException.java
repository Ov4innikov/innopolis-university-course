package part1.lesson02.task01;

/**
 * Класс исключения.
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class HelloWorldException extends RuntimeException {

    /**
     * Конструктор - создание нового объекта
     */
    HelloWorldException() {
        super("Hello World Exception!");
    }
}
