package com.cjc.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ProductController {
    
    @Autowired 
    private ProductServicei ps;
    
    @GetMapping("/inventory")
    public String getInventory() {
        System.out.println("Welcome!!");
        return "xyz";
    }
    
    @PostMapping("/product")
    public ResponseEntity<String> saveProduct(@RequestBody Product product) {
        ps.saveProduct(product);
        return ResponseEntity.ok("Product saved successfully");
    }
    
    @GetMapping("/allData")
    public List<Product> getAllProductData() {
        return ps.getAllData();
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        ps.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
    
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product updatedProduct = ps.updateProduct(id, product);
        if (updatedProduct == null) {
            return ResponseEntity.status(404).body("Product not found");
        }
        return ResponseEntity.ok(updatedProduct);
    }
}
