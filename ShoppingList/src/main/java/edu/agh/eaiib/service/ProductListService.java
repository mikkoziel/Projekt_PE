package edu.agh.eaiib.service;

import edu.agh.eaiib.model.Product;
import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.repository.ProductListRepository;

public class ProductListService {

    private final ProductListRepository repository;

    public ProductListService(ProductListRepository repository) {
        this.repository = repository;
    }

    public void addProduct(Product product) {
        ProductList productList = repository.read();
        productList.add(product);
        repository.save(productList);
    }
}
