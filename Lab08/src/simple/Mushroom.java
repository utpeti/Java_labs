package simple;

import srcpackage.Plant;

public class Mushroom implements Plant{
    @Override
    public double getOxygenAmountPerYear() {
        return 30.1;
    }

    @Override
    public int getLifeTime() {
        return 1;
    }

    @Override
    public String getRepresentation() {
        return "M";
    }
}
