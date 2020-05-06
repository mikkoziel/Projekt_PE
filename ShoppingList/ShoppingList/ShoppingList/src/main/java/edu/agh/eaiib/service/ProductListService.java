package edu.agh.eaiib.service;

import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.repository.ProductListRepository;

public class ProductListService {
    ProductListRepository productListRepository;

    public ProductListService(ProductListRepository productListRepository) {
        this.productListRepository = productListRepository;
    }

    public ProductList addProduct() {
        return null;
    }
}
