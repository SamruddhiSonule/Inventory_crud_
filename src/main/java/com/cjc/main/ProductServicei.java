package com.cjc.main;

import java.util.List;

public interface ProductServicei {
    void saveProduct(Product product);
    List<Product> getAllData();
    void deleteProduct(int id);
    Product updateProduct(int id, Product product);
}
