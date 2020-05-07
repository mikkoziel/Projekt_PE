package edu.agh.eaiib.service;

import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.repository.GsonProductListRepository;
import edu.agh.eaiib.repository.ProductListRepository;

public class ProductListService {

    private ProductListRepository productListRepository;

    public ProductListService(ProductListRepository productListRepository) {
        this.productListRepository = productListRepository;
    }

    public ProductList addProduct() {
        return null;
    }
}
