package part1.lesson11.task01;

import java.util.HashSet;
import java.util.Set;

/**
 * Класс инкапсулирующий в себе HashSet обьектов.
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class ObjectBox<E> {

    public Set<E> list = new HashSet<E>();

    public void addObject(E e) {
        list.add(e);
    }

    public boolean deleteObject(E e) {
        return list.remove(e);
    }

    public void dump() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "ObjectBox{" + "list=" + list + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjectBox<?> objectBox = (ObjectBox<?>) o;

        return list.equals(objectBox.list);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }
}
