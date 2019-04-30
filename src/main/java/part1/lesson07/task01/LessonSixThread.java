package part1.lesson07.task01;

public class LessonSixThread extends Thread {

    private int lastDigitOfDecimalNumber;
    private FactorialData factorialData;
    private int[] arrayInt;

    public LessonSixThread(int[] arrayInt, FactorialData factorialData, int lastDigitOfDecimalNumber) {
        this.arrayInt = arrayInt;
        this.factorialData = factorialData;
        this.lastDigitOfDecimalNumber = lastDigitOfDecimalNumber;
    }

    @Override
    public void run() {
        for (int i = lastDigitOfDecimalNumber; i < arrayInt.length; i += 10) {
            if (arrayInt[i] > 2) {
                if (factorialData.getFactorial(arrayInt[i]) != 0) {
                    arrayInt[i] = factorialData.getFactorial(arrayInt[i]);
                } else {
                    arrayInt[i] = factorialData.updateFactorial(arrayInt[i]);
                }
            }
        }
    }


}
