package case_study.entity;

public class OrderItem {
    private Drink drink;
    private int quantity;

    public OrderItem(Drink drink, int quantity) {
        this.drink = drink;
        this.quantity = quantity;
    }

    public OrderItem() {

    }

    public double getSubtotal() {
        return drink.getPrice() * quantity;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
