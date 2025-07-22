package ss11_java_collection_framework.bai_tap.array_list_linked_list.repository;

import ss11_java_collection_framework.bai_tap.array_list_linked_list.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void add(Product product);

    boolean delete(int id);

    Product findById(int id);

    List<Product> findByName(String name);

    void updateById(int id, Product product);
}
