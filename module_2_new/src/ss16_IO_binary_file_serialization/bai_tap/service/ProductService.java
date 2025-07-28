package ss16_IO_binary_file_serialization.bai_tap.service;

import ss16_IO_binary_file_serialization.bai_tap.entity.Product;
import ss16_IO_binary_file_serialization.bai_tap.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private final ProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public List<Product> searchByName(String keyword) {
        return productRepository.searchByName(keyword);
    }
}
