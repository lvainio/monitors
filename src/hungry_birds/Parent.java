

public class Parent extends Thread {

    private Dish dish; 

    public Parent(Dish dish) {
        this.dish = dish;
    }
    
    @Override
    public void run() {
        while(true) {
            dish.refill();
        }
    }
}
