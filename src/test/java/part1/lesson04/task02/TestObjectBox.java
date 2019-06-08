package part1.lesson04.task02;

import org.junit.Test;
import part1.lesson04.task02.ObjectBox;

public class TestObjectBox {

    @Test
    public void testAddObject() {
        ObjectBox<Object> objectBox = new ObjectBox();
        objectBox.addObject(new Object());
        objectBox.dump();
    }
}
