package ss11_java_collection_framework.bai_tap.array_list_linked_list.repository;

import ss11_java_collection_framework.bai_tap.array_list_linked_list.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {

    private final static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "laptop", 12000, 4, "máy mới chưa sửa chữa"));
        productList.add(new Product(2, "phone", 6000, 2, "máy xách tay"));
    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList);
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public boolean delete(int id) {
        Product product = findById(id);
        if (product != null) {
            productList.remove(product);
            return true;
        }
        return false;
    }

    @Override
    public Product findById(int id) {
        for (Product p : productList) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product p : productList) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public void updateById(int id, Product products) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.set(i, products);
                break;
            }
        }
    }

}
