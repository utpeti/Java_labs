package composite;

import srcpackage.Plant;

import java.util.HashSet;
import java.util.stream.Collectors;

public class Field implements Plant {

    private final HashSet<Plant> plants;

    public Field() {
        plants = new HashSet<>();
    }

    @Override
    public double getOxygenAmountPerYear() {
        return plants.stream().mapToDouble(Plant::getOxygenAmountPerYear).sum();
    }

    @Override
    public int getLifeTime() {
        return plants.stream().mapToInt(Plant::getLifeTime).max().orElse(0);
    }

    @Override
    public String getRepresentation() {
        return plants.stream().map(Plant::getRepresentation).collect(Collectors.joining(", ", "[", "]"));
    }

    public void add(Plant plant) {
        plants.add(plant);
    }

    public void remove(Plant plant) {
        plants.remove(plant);
    }
}
