package edu.agh.eaiib.service;

import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.repository.ProductListRepository;

public class InMemoryProductListRepository implements ProductListRepository {

    ProductList productList = new ProductList("List", "Creator");

    @Override
    public void save(ProductList productList) {
        this.productList = productList;
    }

    @Override
    public ProductList read() {
        return productList;
    }
}
