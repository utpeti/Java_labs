import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tomato extends PizzaIngredient {

    private final BufferedImage img;

    public Tomato(Pizza pizza) throws IOException {
        super(pizza);
        try {
            img = ImageIO.read(new File("img/tomato.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void bake(Graphics graphics) {
        super.bake(graphics);
        graphics.drawImage(img, 0, 0, null);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 3;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", tomato";
    }
}
