package part1.lesson08.task01and02.model;

import java.io.Serializable;

public class TestObject implements Serializable {

    private int i;
    private String s;
    private TestInObject testInObject;

    public TestObject(int i, String s, TestInObject testInObject) {
        this.i = i;
        this.s = s;
        this.testInObject = testInObject;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public TestInObject getTestInObject() {
        return testInObject;
    }

    public void setTestInObject(TestInObject testInObject) {
        this.testInObject = testInObject;
    }

    @Override
    public String toString() {
        return "TestObject{" + "i=" + i + ", s='" + s + '\'' + ", testInObject=" + testInObject + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestObject that = (TestObject) o;

        if (i != that.i) return false;
        if (s != null ? !s.equals(that.s) : that.s != null) return false;
        return testInObject != null ? testInObject.equals(that.testInObject) : that.testInObject == null;
    }

    @Override
    public int hashCode() {
        int result = i;
        result = 31 * result + (s != null ? s.hashCode() : 0);
        result = 31 * result + (testInObject != null ? testInObject.hashCode() : 0);
        return result;
    }
}
