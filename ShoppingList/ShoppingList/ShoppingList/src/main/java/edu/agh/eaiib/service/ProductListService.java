package edu.agh.eaiib.service;

import edu.agh.eaiib.model.Product;
import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.repository.ProductListRepository;

public class ProductListService {
    ProductListRepository productListRepository;

    public ProductListService(ProductListRepository productListRepository) {
        this.productListRepository = productListRepository;
    }

    public void createList(ProductList productList){
        productListRepository.save(productList);
    }

    public ProductList getList(){
        return productListRepository.read();
    }

    public void addProduct(Product product) {
        ProductList list = productListRepository.read();
        list.addProduct(product);
        productListRepository.save(list);
    }

    public void addUser(String name){
        ProductList list = productListRepository.read();
        list.addUser(name);
        productListRepository.save(list);
    }
}
