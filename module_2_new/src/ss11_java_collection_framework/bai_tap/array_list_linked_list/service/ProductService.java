package ss11_java_collection_framework.bai_tap.array_list_linked_list.service;

import ss11_java_collection_framework.bai_tap.array_list_linked_list.entity.Product;
import ss11_java_collection_framework.bai_tap.array_list_linked_list.repository.IProductRepository;
import ss11_java_collection_framework.bai_tap.array_list_linked_list.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService {

    private final IProductRepository repository = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(Product product) {
        repository.add(product);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void updateById(int id, Product product) {
        repository.updateById(id, product);
    }
    
}
