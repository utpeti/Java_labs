import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PizzaBase implements Pizza{

    private final BufferedImage img;

    public PizzaBase() {
        try {
            img = ImageIO.read(new File("img/pizza_base.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void bake(Graphics graphics) {
        graphics.drawImage(img, 0, 0, null);
    }

    @Override
    public int getPrice() {
        return 15;
    }

    @Override
    public String getIngredients() {
        return "pizza base, tomato sauce, cheese";
    }
}
