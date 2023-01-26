import java.util.Random;

public class Baby extends Thread {
    private Dish dish;
    private int id;
    private int numEaten = 0;

    private Random rng = new Random();
    private long sleepTime;

    public Baby(Dish dish, int id) {
        this.dish = dish;
        this.id = id;
        sleepTime = rng.nextInt(2000) + 1000;
    }

    @Override
    public void run() {
        while (true) {
            numEaten++;
            dish.eat(id, numEaten);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                System.exit(1);
            }
        }
    }
}
