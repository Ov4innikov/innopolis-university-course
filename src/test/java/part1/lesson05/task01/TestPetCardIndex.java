package part1.lesson05.task01;

import org.junit.Assert;
import org.junit.Test;
import part1.lesson05.task01.exception.DublicatePetEcxeption;
import part1.lesson05.task01.model.*;

public class TestPetCardIndex {

    @Test
    public void testSuccesAddAndPrintPets() throws DublicatePetEcxeption {
        PetCardIndex<Pet> petCardIndex = new PetCardIndex<Pet>();
        Owner owner1 = new Owner("Jack", 20, Sex.MAN);
        Owner owner2 = new Owner("Anton", 21, Sex.MAN);
        Pet pet1 = new Dog(1, "Bobick", owner1, 30);
        Pet pet2 = new Cat(2, "Sherlock", owner1, 5);
        Pet pet3 = new Cat(3, "Aza", owner1, 7);
        Pet pet4 = new Cat(4, "Mark", owner2, 7);
        Pet pet5 = new Cat(5, "Aza", owner2, 8);
        Pet pet6 = new Cat(6, "Ada", owner1, 3);
        petCardIndex.add(pet1);
        petCardIndex.add(pet2);
        petCardIndex.add(pet3);
        petCardIndex.add(pet4);
        petCardIndex.add(pet5);
        petCardIndex.add(pet6);
        petCardIndex.printPets();
    }

    @Test
    public void testDublicateAddAndPrintPets() {
        PetCardIndex<Pet> petCardIndex = new PetCardIndex<Pet>();
        Owner owner = new Owner("Jack", 20, Sex.MAN);
        Pet pet1 = new Dog(1, "Bobick", owner, 30);
        Pet pet2 = new Cat(2, "Sherlock", owner, 5);
        Pet pet3 = new Cat(2, "Sherlock", owner, 5);
        Class<? extends Exception> expectedClassException = DublicatePetEcxeption.class;
        Class<? extends Exception> actualClassException = Exception.class;
        try {
            petCardIndex.add(pet1);
            petCardIndex.add(pet2);
            petCardIndex.add(pet3);
        } catch (Exception e) {
            actualClassException = e.getClass();
        }
        petCardIndex.printPets();
        Assert.assertEquals(expectedClassException, actualClassException);
    }
}
