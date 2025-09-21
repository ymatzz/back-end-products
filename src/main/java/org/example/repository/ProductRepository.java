package org.example.repository;

import org.example.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private final List<Product> products = new ArrayList<Product>();
    private static long nextId = 1;

    public ProductRepository() {
        save(new Product(null, "Caneca", 45.9, "https://cdn.awsli.com.br/400x400/994/994552/produto/348976887/whatsapp-image-2025-04-22-at-11-07-16-qsu2x6mao2.jpeg"));
        save(new Product(null, "Almofada Dev", 89.99, "https://mais1nerd.com.br/wp-content/uploads/2021/10/capa-dev-null.jpg.webp"));
        save(new Product(null, "Fone JBL", 150.0, "https://m.media-amazon.com/images/I/51olNZRjn+L._AC_SY300_SX300_QL70_ML2_.jpg"));
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(nextId++);
            products.add(product);
        } else {
            deleteById(product.getId());
            products.add(product);
        }
        return product;
    }

    public void deleteById(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public List<Product> findAll() {
        return products;
    }
}
