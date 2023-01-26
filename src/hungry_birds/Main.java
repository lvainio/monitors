
// compile: javac *.java
// run: java Main <num_babies>

class Main {
    private final static int MAX_BABIES = 50;

    public static void main(String[] args) {
        // command line args
        int num_babies = MAX_BABIES;
        try {
            if (args.length > 0) {
                num_babies = Integer.parseInt(args[0]);
                if (num_babies > MAX_BABIES || num_babies <= 0) {
                    num_babies = MAX_BABIES;
                }
            }
        } catch (NumberFormatException nfe) { 
            // num_babies = MAX_BABIES
        }
        System.out.println("\n>> Spawning parent bird and her " + num_babies + " baby birds.");
        System.out.println(">> Lets watch as they feed forever.\n");
        
        // create objects
        Dish dish = new Dish(num_babies);
        Parent parent = new Parent(dish);
        Baby[] babies = new Baby[num_babies];
        for (int i = 0; i < babies.length; i++) {
            babies[i] = new Baby(dish, i+1);
        }

        // start threads
        parent.start();
        for (int i = 0; i < babies.length; i++) {
            babies[i].start();
        }
    }
}