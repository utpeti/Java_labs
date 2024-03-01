import composite.Field;
import composite.Forest;
import simple.*;

public class Main {
    public static void main(String[] args) {
        Field myField1 = new Field();

        Grass grass = new Grass();
        Flower flower = new Flower();

        myField1.add(grass);
        myField1.add(flower);

        Field myField2 = new Field();

        Mushroom mushroom1 = new Mushroom();
        Mushroom mushroom2 = new Mushroom();

        myField2.add(mushroom1);
        myField2.add(mushroom2);

        Forest myForest = new Forest();

        PineTree pineTree = new PineTree();
        OakTree oakTree = new OakTree();

        myForest.add(myField1);
        myForest.add(myField2);

        myForest.add(pineTree);
        myForest.add(oakTree);
        myForest.add(flower);
        myForest.remove(flower);

        System.out.println(myForest.getRepresentation());
        System.out.println(myForest.getOxygenAmountPerYear());
        System.out.println(myForest.getLifeTime());

        System.out.println(myField1.getRepresentation());
        System.out.println(myField1.getOxygenAmountPerYear());
        System.out.println(myField1.getLifeTime());
        System.out.println(myField2.getRepresentation());
        System.out.println(myField2.getOxygenAmountPerYear());
        System.out.println(myField2.getLifeTime());
    }
}