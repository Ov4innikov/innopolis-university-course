package part1.lesson05.task01;

import part1.lesson05.task01.model.Pet;

import java.util.Comparator;

public class PetWeightComparator implements Comparator<Pet> {

    @Override
    public int compare(Pet o1, Pet o2) {
        if (o1.getWeight() > o2.getWeight()){
            return 1;
        } else if (o1.getWeight() < o2.getWeight()) {
            return -1;
        }
        return 0;
    }
}
