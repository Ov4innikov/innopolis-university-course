package part1.lesson02.task02;

/**
 * Класс решения второго задания.
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class Application {

    public static void main(String[] args) {
        int n = 0;
        if (args.length == 0) n = 1000000;
        else n = Integer.valueOf(args[0]);
        int randomVector[] = VectorRandomGenerator.generateIntRandomVector(n);

        for (int num : randomVector) {
            try {
                if (num <= 0) throw new ArithmeticException();
                int sqrtOfNum = (int) Math.sqrt(num);
                int sqr = sqrtOfNum * sqrtOfNum;
                if (num == sqr) System.out.println(num);
            } catch (ArithmeticException e) {
                //System.err.println(e);
            }
        }
    }
}
