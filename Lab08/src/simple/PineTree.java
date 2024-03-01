package simple;

import srcpackage.Plant;

public class PineTree implements Plant{
    @Override
    public double getOxygenAmountPerYear() {
        return 176.088;
    }

    @Override
    public int getLifeTime() {
        return 45;
    }

    @Override
    public String getRepresentation() {
        return "P";
    }
}
