package part1.lesson02.task02;

import java.security.SecureRandom;

/**
 * Класс утилитный, для генерации массива случайных чисел.
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class VectorRandomGenerator {

    private static SecureRandom secureRandom = new SecureRandom();

    /**
     * Функция генерирует вектор со случайными double значенями эллементов
     *
     * @param n - размер массива
     * @return массив длинной n со случайными значениями эллементов
     */
    public static double[] generateDoubleRandomVector(Integer n) {
        double vector[] = new double[n];
        for (int i = 0; i < n; i++) {
            vector[i] = secureRandom.nextDouble();
        }
        return vector;
    }

    /**
     * Функция генерирует вектор со случайными int значенями эллементов
     *
     * @param n - размер массива
     * @return массив длинной n со случайными значениями эллементов
     */
    public static int[] generateIntRandomVector(Integer n) {
        int vector[] = new int[n];
        for (int i = 0; i < n; i++) {
            vector[i] = secureRandom.nextInt();
        }
        return vector;
    }
}
