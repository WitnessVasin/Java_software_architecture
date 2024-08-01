package practice_gb_1_sa.store;

public class OrderItem {

    private  static  int counter = 5000;

    private int id;

    private Product product;

    private int quantity;

    {
        id = ++counter;
    }

    public OrderItem(Product product){
        this.product = product;
        quantity = 1;

    }

    public OrderItem(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }
}
