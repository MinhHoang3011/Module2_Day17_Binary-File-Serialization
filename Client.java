package BaiTAp;

import java.io.IOException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = null;
        try {
            productManager = new ProductManager();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        int choice;
        do {
            System.out.println("Menu sản phẩm");
            System.out.println("1.Tạo sản phẩm");
            System.out.println("2.Hiển thị tất cả sản phẩm");
            System.out.println("3. Hiển thị theo mã sản phẩm");
            System.out.println("0. Exit");
            System.out.println("Nhập lựa chọn");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    assert productManager != null;
                    try {
                        productManager.createProduct();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    assert productManager != null;
                    productManager.displayAll();
                    break;
                case 3:
                    System.out.println("Nhập id sản phẩm");
                    String id = scanner.nextLine();
                    assert productManager != null;
                    productManager.findProduct(id);
                    break;
            }
        } while (choice != 0);
    }
}
