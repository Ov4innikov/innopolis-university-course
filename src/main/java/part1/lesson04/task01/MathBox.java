package part1.lesson04.task01;

import part1.lesson04.task01.exception.DublicateNumberException;
import part1.lesson04.task02.ObjectBox;

import java.util.*;

/**
 * Класс инкапсулирующий в себе HashSet<Number>
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class MathBox<E extends Number> extends ObjectBox<Number> {

    public MathBox(E[] numbers) throws DublicateNumberException {
        for (E num : numbers) {
            if (!list.add(num)) throw new DublicateNumberException();
        }
    }

    /**
     * Метод возвращает сумму всех элементов коллекции.
     *
     * @return сумма всех эллекментов
     */
    public double summator() {
        double sum = 0;
        for (Number num : list) {
            sum = sum + num.doubleValue();
        }
        return sum;
    }

    /**
     * Метод выполняет поочередное деление всех хранящихся в объекте элементов на делитель,
     * являющийся аргументом метода.
     *
     * @param divider - делитель
     */
    public void splitter(Number divider) {
        Set<Number> numbers = new HashSet<Number>();
        for (Number num : list) {
            numbers.add(num.doubleValue() / divider.doubleValue());
        }
        list = numbers;
    }

    /**
     * Метод удаляет эллемент Integer из множества, елси он присутствует в нём.
     *
     * @param integer - делитель
     */
    public void removeInteger(Integer integer) {
        list.remove(integer);
    }

    @Override
    public String toString() {
        return "MathBox{" + "list=" + list + '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
