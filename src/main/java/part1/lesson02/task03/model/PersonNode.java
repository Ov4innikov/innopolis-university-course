package part1.lesson02.task03.model;

/**
 * Узел для построения двухсвязаного списка из обьектов Person
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class PersonNode {

    private Person person;
    private PersonNode prev;
    private PersonNode next;

    public PersonNode(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PersonNode getPrev() {
        return prev;
    }

    public void setPrev(PersonNode prev) {
        this.prev = prev;
        if (prev != null && prev.getNext() != this) prev.setNext(this);
    }

    public PersonNode getNext() {
        return next;
    }

    public void setNext(PersonNode next) {
        this.next = next;
        if (next != null && next.getPrev() != this) next.setPrev(this);
    }

    public boolean hasPrev() {
        if (prev == null) return false;
        return true;
    }

    public boolean hasNext() {
        if (next == null) return false;
        return true;
    }

    public void putBefore(PersonNode personNode) {
        personNode.setPrev(prev);
        personNode.setNext(this);
    }

    public void remove() {
        if (prev != null) prev.setNext(this.next);
        if (next != null) next.setPrev(this.prev);
        prev = null;
        next = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonNode that = (PersonNode) o;

        if (!person.equals(that.person)) return false;
        if (prev != null ? !prev.equals(that.prev) : that.prev != null) return false;
        return next != null ? next.equals(that.next) : that.next == null;
    }

    @Override
    public int hashCode() {
        int result = person.hashCode();
        result = 31 * result + (prev != null ? prev.hashCode() : 0);
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }
}
