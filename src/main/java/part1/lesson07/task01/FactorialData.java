package part1.lesson07.task01;

public class FactorialData {

    private int[] factorials = new int[1000];
    private volatile int lastIndx = 2;

    {
        factorials[0] = 0;
        factorials[1] = 1;
        factorials[2] = 2;
        factorials[3] = 6;
    }

    public int getFactorial(int f) {
        return factorials[f];
    }

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
