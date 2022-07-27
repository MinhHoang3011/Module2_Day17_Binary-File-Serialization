package BaiTAp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private List<Product> listProduct;
    private File file = new File("src/product.dat");
    Scanner scanner = new Scanner(System.in);

    public ProductManager() throws IOException, ClassNotFoundException {
        if (file.length() == 0) {
            listProduct = new ArrayList<>();
        } else {
            listProduct = open();
        }
    }

    public void displayAll() {
        listProduct.forEach(System.out::println);
    }

    public Product createProduct() throws IOException {
        Product product = null;
        System.out.println("Nhập mã sản phẩm");
        String id = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm");
        String name = scanner.nextLine();
        System.out.println("Nhập hãng sản phẩm");
        String brand = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập mô tả sản phẩm");
        String description = scanner.nextLine();
        product = new Product(id, name, brand, price, description);
        listProduct.add(product);
        save();
        return product;
    }

    public void findProduct(String id) {
        listProduct.stream().filter(s -> s.getId().equalsIgnoreCase(id))
                .forEach(System.out::println);
    }


    public void save() throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(listProduct);
        oos.close();
    }

    public List<Product> open() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream oos = new java.io.ObjectInputStream(fis);
        listProduct = (List<Product>) oos.readObject();
        oos.close();
        return listProduct;
    }
}
