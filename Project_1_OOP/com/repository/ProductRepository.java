package com.repository;

import com.config.MyConfig;
import com.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductRepository {
    private List<Product> products;
    private MyConfig config;

    public ProductRepository() {
        products = new ArrayList<>();
        config = new MyConfig();
    }

    // MEMBACA DATA
    public void readData() {
        config.getDatabase();
    }

    // MENAMBAHKAN DATA
    public void insertData(Product product) {
        Product existingProduct = getProductByName(product.getNama());
        if (existingProduct != null) {
            System.out.println("Data with the same name already exists. Please enter a different name.");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nama: ");
            String newName = scanner.nextLine();
            product.setNama(newName);
            insertData(product); // Memanggil kembali method insertData dengan data yang sudah diubah
            scanner.close();
            return;
        }
    
        products.add(product);
        config.insertData(product.getNama(), product.getHarga(), product.getStock());
        System.out.println("Data inserted successfully.");
    }
    

    // FILTER DATA BERDASARKAN NAMA AGAR TIDAK ADA BARANG YANG DUPLIKAT
    private Product getProductByName(String nama) {
        for (Product product : products) {
            if (product.getNama().equalsIgnoreCase(nama)) {
                return product;
            }
        }
        return null;
    }
    
    // MEMPERBARUI DATA
    public void updateData(Product product, Product updatedProduct) {
        Product existingProduct = getProductById(product.getId());
        if (existingProduct != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nama: ");
            String newName = scanner.nextLine();
            System.out.print("Harga: ");
            int newHarga = scanner.nextInt();
            System.out.print("Nama: ");
            int newStock = scanner.nextInt();
            updatedProduct.setNama(newName);
            updatedProduct.setHarga(newHarga);
            updatedProduct.setStock(newStock);
            updateData(existingProduct, updatedProduct); // Memanggil kembali method insertData dengan data yang sudah diubah
            scanner.close();
            return;
        }
    
        products.add(product);
        config.updateData(product.getId(), updatedProduct.getNama(), updatedProduct.getHarga(), updatedProduct.getStock());
    } 

    // MENGHAPUS DATA
    public void deleteData(Product product) {
        config.deleteData(product.getId());

    }

    private Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() != 0) {
                return product;
            }
        }
        return null;
    }
    
}
