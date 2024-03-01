package composite;

import srcpackage.Plant;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Forest implements Plant {

    private final ArrayList<Plant> plants;

    public Forest() {
        plants = new ArrayList<>();
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
        return plants.stream().map(Plant::getRepresentation).collect(Collectors.joining(", ", "{", "}"));
    }

    public void add(Plant plant) {
        plants.add(plant);
    }

    public void remove(Plant plant) {
        plants.remove(plant);
    }
}
