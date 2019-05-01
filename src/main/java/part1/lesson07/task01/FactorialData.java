package part1.lesson07.task01;

/**
 * Класс хранящий данные о факториалах, для получения, либо синхроного обновления
 * данных из множества потоков.
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class FactorialData {

    private int[] factorials = new int[1000];
    private volatile int lastIndx = 2;

    {
        factorials[0] = 0;
        factorials[1] = 1;
        factorials[2] = 2;
        factorials[3] = 6;
    }

    /**
     * Функция для получения факториала, если факториал еще не вычеслен, возвращается ноль
     *
     * @param f - число для которого нужно вычислить факториал
     * @return факториал числа
     */
    public int getFactorial(int f) {
        return factorials[f];
    }

    /**
     * Функция для вычисления факториала.
     * Вычисленое значение помещается в массив.
     *
     * @param f - число для которого нужно вычислить факториал
     * @return факториал числа
     */
    public synchronized int updateFactorial(int f) {
        if (factorials[f] == 0) {
            System.out.println(f + " - " + factorials[f]);
            for (int i = lastIndx; i < f; i++) {
                factorials[i + 1] = factorials[i] * (i + 1);
            }
            lastIndx = f;
        }
        return factorials[f];
    }
}
