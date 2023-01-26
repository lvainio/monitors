
// monitor

public class Pot {

    private int capacity;
    private int numHoney;

    public Pot(int num_bees) {
        capacity = num_bees * 4;
        numHoney = 0;
    }

    // eat method for baby
    public synchronized void eat() {
        try {
            this.wait();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
            System.exit(1);
        }
        System.out.println(">> Ahhhh honey, thank you bees!");
        System.out.println(">> I'm going to sleep, wake me up when the pot is filled again!");
        numHoney = 0;
        this.notify();
    }

    // refill method for parent
    public synchronized void fill(int id, int numFilled) {
        numHoney++;
        System.out.println(">> Bee " + id + " just filled the pot for the " + numFilled + "th time! The pot has " + numHoney + " honey in it");
        if (numHoney == capacity) {
            System.out.println(">> The pot is filled, wake up bear!");
            this.notify();
            try {
                this.wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                System.exit(1);
            }
        }
    }
}
