package com.layout;

import com.repository.ProductRepository;

public class ReadData {
    public static void read() {
        ProductRepository productRepository = new ProductRepository();
        productRepository.readData();
    }
}
