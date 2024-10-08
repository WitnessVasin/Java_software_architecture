package practice_gb_1_sa.store;

public class Product {

    private static int counter = 100;
    private int id;

    private String name;

    private double price;

    private String category;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    {
        id = ++counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
