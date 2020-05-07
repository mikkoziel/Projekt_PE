package edu.agh.eaiib.repository;

import com.google.gson.Gson;
import edu.agh.eaiib.model.ProductList;

import java.io.*;

public class GsonProductListRepository implements ProductListRepository {

    public GsonProductListRepository(String productsFileName) {
        this.productsFileName = productsFileName;
    }

    final static Gson gson = new Gson();
    public final String productsFileName;

    @Override
    public void save(ProductList productList) {
        try (FileWriter writer = new FileWriter(productsFileName)) {
            gson.toJson(productList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ProductList read() {
        try (Reader reader = new FileReader(productsFileName)) {
            return gson.fromJson(reader, ProductList.class);
        } catch (FileNotFoundException e) {
            return new ProductList();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
