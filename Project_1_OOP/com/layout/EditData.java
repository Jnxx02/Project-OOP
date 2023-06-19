package com.layout;

import java.util.Scanner;

import com.model.Product;
import com.repository.ProductRepository;

public class EditData {
    public static void edit() {
        Scanner scanner = new Scanner(System.in);
        ProductRepository productRepository = new ProductRepository();
        System.out.print("ID: ");
        int editId = scanner.nextInt();
        System.out.print("Nama: ");
        scanner.nextLine();
        String editNama = scanner.nextLine();
        System.out.print("Harga: ");
        int editHarga = scanner.nextInt();
        System.out.print("Stock: ");
        int editStock = scanner.nextInt();
        Product editedProduct = new Product(editId, editNama, editHarga, editStock);
        Product producted = new Product(editId);
        productRepository.updateData(producted, editedProduct);
        scanner.close();
    }
}
