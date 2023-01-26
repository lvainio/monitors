
// monitor

public class Dish {

    private int capacity;
    private int numWormsLeft;

    public Dish(int num_babies) {
        capacity = num_babies * 4;
        numWormsLeft = capacity;
    }

    // eat method for baby
    public synchronized void eat(int id, int numEaten) {
        if (numWormsLeft == 0) {
            System.out.println("CHIRP CHIRP CHIRP! NO MORE WORMS!!!");
            this.notify();
            try {
                this.wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                System.exit(1);
            }
        } 
        numWormsLeft--;
        System.out.println(">> Bird " + id + " just ate its " + numEaten + ":th worm! There are " + numWormsLeft + " worms left!");
    }

    // refill method for parent
    public synchronized void refill() {
        try {
            this.wait();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
            System.exit(1);
        }
        numWormsLeft = capacity;
        System.out.println(">> I refilled the dish kids!"); 
        notify();
    }
}
