package part1.lesson05.task01;

import part1.lesson05.task01.model.Pet;

import java.util.Comparator;

public class PetOwnerNameComparator implements Comparator<Pet> {

    @Override
    public int compare(Pet o1, Pet o2) {
        return o1.getOwner().getName().compareTo(o2.getOwner().getName());
    }
}
