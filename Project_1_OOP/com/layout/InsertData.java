package com.layout;

import java.util.Scanner;

import com.model.Product;
import com.repository.ProductRepository;

public class InsertData {
    public static void insert() {
        Scanner scanner = new Scanner(System.in);
        ProductRepository productRepository = new ProductRepository();
        System.out.print("Nama: ");
        scanner.nextLine();
        String nama = scanner.nextLine();
        System.out.print("Harga: ");
        int harga = scanner.nextInt();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        Product newProduct = new Product(0, nama, harga, stock);
        productRepository.insertData(newProduct);
        scanner.close();
    }
}
