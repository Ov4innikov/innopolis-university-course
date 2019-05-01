package part1.lesson07.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Класс запускающий потоки для преобразования массива.
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class FactorialExecutor {

    private int[] arrayInt;
    private FactorialData factorialData = new FactorialData();
    ExecutorService service = Executors.newFixedThreadPool(10);

    public FactorialExecutor(int[] arrayInt) {
        this.arrayInt = arrayInt;
    }

    /**
     * Функция для запуска пула потоков, которые вычисляют факториал и преобразут массив.
     *
     * @throws InterruptedException
     */
    public void go() throws InterruptedException {
        List<LessonSixThread> threads = new ArrayList<LessonSixThread>();
        for (int i = 0; i < 10; i++) {
            LessonSixThread thread = new LessonSixThread(arrayInt, factorialData, i);
            threads.add(thread);
            service.execute(thread);
        }
        for (LessonSixThread thread : threads) {
            thread.join();
        }
        service.shutdown();
    }
}
