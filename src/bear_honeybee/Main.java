
// compile: javac *.java
// run: java Main <num_bees>

class Main {
    private final static int MAX_BEES = 50;

    public static void main(String[] args) {
        // command line args
        int num_bees = MAX_BEES;
        try {
            if (args.length > 0) {
                num_bees = Integer.parseInt(args[0]);
                if (num_bees > MAX_BEES || num_bees <= 0) {
                    num_bees = MAX_BEES;
                }
            }
        } catch (NumberFormatException nfe) { 
            // num_bees = MAX_BEES
        }
        System.out.println("\n>> Spawning bear and " + num_bees + " honeybees.");
        System.out.println(">> Lets watch as the bees feed the bear.\n");
        
        // create objects
        Pot pot = new Pot(num_bees);
        Bear bear = new Bear(pot);
        Bee[] bees = new Bee[num_bees];
        for (int i = 0; i < bees.length; i++) {
            bees[i] = new Bee(pot, i+1);
        }

        // start threads
        bear.start();
        for (int i = 0; i < bees.length; i++) {
            bees[i].start();
        }
    }
}