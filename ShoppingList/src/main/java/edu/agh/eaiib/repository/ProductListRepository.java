package edu.agh.eaiib.repository;

import edu.agh.eaiib.model.ProductList;

public interface ProductListRepository {
    void save(ProductList productList);

    ProductList read();

}
