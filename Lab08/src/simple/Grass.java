package simple;

import srcpackage.Plant;

public class Grass implements Plant{
    @Override
    public double getOxygenAmountPerYear() {
        return 17.6;
    }

    @Override
    public int getLifeTime() {
        return 1;
    }

    @Override
    public String getRepresentation() {
        return "G";
    }
}
