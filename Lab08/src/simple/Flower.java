package simple;

import srcpackage.Plant;

public class Flower implements Plant {

    @Override
    public double getOxygenAmountPerYear() {
        return 41.9;
    }

    @Override
    public int getLifeTime() {
        return 1;
    }

    @Override
    public String getRepresentation() {
        return "F";
    }
}
