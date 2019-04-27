package part1.lesson05.task01;

import org.junit.Assert;
import org.junit.Test;
import part1.lesson05.task01.exception.DublicatePetEcxeption;
import part1.lesson05.task01.model.*;

public class TestPetCardIndex {

    @Test
    public void testSuccesAdd() {
        PetCardIndex<Pet> petPetCardIndex = new PetCardIndex<Pet>();


    }

    @Test
    public void testDublicateAdd() {
        PetCardIndex<Pet> petPetCardIndex = new PetCardIndex<Pet>();
        Owner owner = new Owner("Jack", 20, Sex.MAN);
        Pet pet1 = new Dog(1, "Bobick", owner, 30);
        Pet pet2 = new Cat(2, "Sherlock", owner, 5);
        Pet pet3 = new Cat(2, "Sherlock", owner, 5);
        Class<? extends Exception> expectedClassException = DublicatePetEcxeption.class;
        Class<? extends Exception> actualClassException = null;
        try {
            petPetCardIndex.add(pet1);
            petPetCardIndex.add(pet2);
            petPetCardIndex.add(pet3);
        } catch (Exception e) {
            actualClassException = e.getClass();
        }
        Assert.assertEquals(expectedClassException, actualClassException);
    }
}
