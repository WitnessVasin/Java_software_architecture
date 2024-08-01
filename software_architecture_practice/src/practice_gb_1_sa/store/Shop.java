package practice_gb_1_sa.store;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private List<Order> orders = new ArrayList<>();

    public boolean addOrder(Order order){
        orders.add(order);
        return true;
    }

    public boolean cancelOrder(int id){
        //T000: Cancel order
        return true;
    }

    public boolean paymentOrder(int id){
        //T000: pay order
        return true;
    }
}
