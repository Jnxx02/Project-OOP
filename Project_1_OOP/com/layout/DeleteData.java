package com.layout;

import java.util.Scanner;

import com.model.Product;
import com.repository.ProductRepository;

public class DeleteData {
    public static void delete() {
        Scanner scanner = new Scanner(System.in);
        ProductRepository productRepository = new ProductRepository();
        System.out.print("ID: ");
        int deleteId = scanner.nextInt();
        Product product = new Product(deleteId);
        productRepository.deleteData(product);;
        scanner.close();
    }
}
