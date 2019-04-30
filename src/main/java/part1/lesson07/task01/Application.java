package part1.lesson07.task01;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        int[] ints = VectorRandomGenerator.generateIntRandomVector(100);
        FactorialExecutor factorialExecutor = new FactorialExecutor(ints);
        for (int i : ints) {
            System.out.print(i + ";");
        }
        System.out.println("\nStart executor");
        factorialExecutor.go();
        for (int i : ints) {
            System.out.print(i + ";");
        }
        System.out.println("\nEnd");
    }
}
