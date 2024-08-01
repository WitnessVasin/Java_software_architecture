package practice_gb_1_sa.store;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static int  counter = 10000;

    private int id;

    private LocalDateTime orderDate;

    private String address;

    private String phone;

    private Buyer buyer;

    private List<OrderItem> items = new ArrayList<>();

    {
        id = ++counter;
    }

    public Order(LocalDateTime orderDate, String address, String phone, Buyer buyer, List<OrderItem> items) {

        if (buyer == null){
            throw new RuntimeException("buyer not found");
        }

        if (items == null || items.isEmpty()) {
            throw new RuntimeException("items must have contain at least one product");
        }

        this.orderDate = orderDate;
        this.address = address;
        this.phone = phone;
        this.buyer = buyer;
        this.items = items;
    }
}
