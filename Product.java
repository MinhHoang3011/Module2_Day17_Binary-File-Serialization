package BaiTAp;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private String brand;
    private double price;
    private String description;

    public Product() {
    }

    public Product(String code, String name, String brand, double price, String description) {
        this.id = code;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String code) {
        this.id = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
