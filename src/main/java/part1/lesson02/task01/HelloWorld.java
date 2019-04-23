package part1.lesson02.task01;

/**
 * Класс решения первого задания.
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class HelloWorld {

    static String nullString;

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int[] ints = new int[1];
        try {
            System.out.println(ints[1]);
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e);
        }

        try {
            nullString = nullString.concat("");
        } catch (NullPointerException e) {
            System.err.println(e);
        }

        try {
            System.out.println(ints[0]/0);
        } catch (ArithmeticException e) {
            System.err.println(e);
            throw new HelloWorldException();
        }
    }
}
