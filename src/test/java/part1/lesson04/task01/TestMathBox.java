package part1.lesson04.task01;

import org.junit.Assert;
import org.junit.Test;
import part1.lesson04.task01.MathBox;
import part1.lesson04.task01.exception.DublicateNumberException;

public class TestMathBox {

    @Test
    public void testConstructorWithArrayParameter() throws DublicateNumberException {
        Number[] numbers = {1,2.0,2,3,4,5};
        MathBox<Number> numberMathBox = new MathBox<Number>(numbers);
        numberMathBox.dump();
    }

    @Test
    public void testAddDublicate() throws DublicateNumberException {
        Number[] numbers = {2,2,3,4,5};
        Exception expectedException = new DublicateNumberException();
        Exception actualException = null;
        MathBox<Number> numberMathBox;
        try {
            numberMathBox = new MathBox<Number>(numbers);
        } catch (DublicateNumberException e) {
            actualException = e;
        }
        Assert.assertEquals(expectedException.getClass(), actualException.getClass());
    }
}
