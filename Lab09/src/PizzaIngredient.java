import java.awt.*;

public abstract class PizzaIngredient implements Pizza{

    private final Pizza pizza;


    public PizzaIngredient(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public void bake(Graphics graphics) {
        pizza.bake(graphics);
    }

    @Override
    public int getPrice() {
        return pizza.getPrice();
    }

    @Override
    public String getIngredients() {
        return pizza.getIngredients();
    }
}
