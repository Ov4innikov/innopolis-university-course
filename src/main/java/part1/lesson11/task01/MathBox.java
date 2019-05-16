package part1.lesson11.task01;

import part1.lesson11.task01.exception.DublicateNumberException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
        return list.stream().mapToDouble(num -> num.doubleValue()).sum();
    }

    /**
     * Метод выполняет поочередное деление всех хранящихся в объекте элементов на делитель,
     * являющийся аргументом метода.
     *
     * @param divider - делитель
     */
    public void splitter(Number divider) {
        list = list.stream().mapToDouble(num -> num.doubleValue()/divider.doubleValue()).boxed().collect(Collectors.toSet());
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
