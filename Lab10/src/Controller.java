import java.util.concurrent.ThreadLocalRandom;

public class Controller implements Runnable {
    private Virag virag;
    private View view;

    public Controller(Virag virag, View view) {
        this.virag = virag;
        this.view = view;
    }

    @Override
    public void run() {
        int i = 0;
        ThreadLocalRandom range = ThreadLocalRandom.current();
        while (i < virag.getMax()) {

            i += range.nextInt(20);

            virag.setSeed(i);
            view.repaint();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
