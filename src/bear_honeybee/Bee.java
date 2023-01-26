import java.util.Random;

public class Bee extends Thread {
    private Pot pot;
    private int id;
    private int numFilled = 0;

    private Random rng = new Random();
    private long sleepTime;

    public Bee(Pot pot, int id) {
        this.pot = pot;
        this.id = id;
        sleepTime = rng.nextInt(2000) + 1000;
    }

    @Override
    public void run() {
        while (true) {
            numFilled++;
            pot.fill(id, numFilled);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                System.exit(1);
            }
        }
    }
}
