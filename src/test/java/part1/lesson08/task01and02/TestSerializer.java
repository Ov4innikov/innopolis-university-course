package part1.lesson08.task01and02;

import org.junit.Assert;
import org.junit.Test;
import part1.lesson08.task01and02.model.TestInObject;
import part1.lesson08.task01and02.model.TestObject;

import java.io.IOException;

public class TestSerializer {

    @Test
    public void testSerializeAndDeserialize() throws IOException, ClassNotFoundException {

        TestInObject testInObject = new TestInObject(2, "object 2");
        TestObject testObject = new TestObject(1, "object 1", testInObject);
        System.out.println(testObject);
        Serializer.serialize(testObject, "testfile");
        TestObject testObjectResult = (TestObject) Serializer.deSerialize("testfile");
        System.out.println(testObjectResult);
        Assert.assertEquals(testObject, testObjectResult);
    }
}
