

public class Bear extends Thread {
    private Pot pot; 

    public Bear(Pot pot) {
        this.pot = pot;
    }
    
    @Override
    public void run() {
        while(true) {
            pot.eat();
        }
    }
}
