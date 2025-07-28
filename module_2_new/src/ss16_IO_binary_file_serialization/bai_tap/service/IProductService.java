package ss16_IO_binary_file_serialization.bai_tap.service;

import ss16_IO_binary_file_serialization.bai_tap.entity.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    void addProduct(Product product);

    List<Product> searchByName(String keyword);
}
