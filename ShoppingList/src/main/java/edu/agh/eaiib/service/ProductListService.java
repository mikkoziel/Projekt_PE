package edu.agh.eaiib.service;

import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.repository.GsonProductListRepository;
import edu.agh.eaiib.repository.ProductListRepository;

public class ProductListService {

    private static final ProductListService instance = new ProductListService();
    private ProductListRepository productListRepository;

    public static ProductListService getInstance() {
        return instance;
    }

    private ProductListService() {
        this.productListRepository = new GsonProductListRepository("database.json");
    }

    public ProductList addProduct() {
        return null;
    }
}
