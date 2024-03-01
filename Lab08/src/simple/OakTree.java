package simple;

import srcpackage.Plant;

public class OakTree implements Plant{
    @Override
    public double getOxygenAmountPerYear() {
        return 311.9;
    }

    @Override
    public int getLifeTime() {
        return 78;
    }

    @Override
    public String getRepresentation() {
        return "O";
    }
}
