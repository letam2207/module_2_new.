package ss16_IO_binary_file_serialization.bai_tap.repository;

import ss16_IO_binary_file_serialization.bai_tap.common.BinaryFileUtil;
import ss16_IO_binary_file_serialization.bai_tap.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final String FILE_PATH = "src/ss16_IO_binary_file_serialization/bai_tap/data/product.dat";

    public void save(List<Product> productList) {
        BinaryFileUtil.writeToFile(FILE_PATH, productList);
    }

    @Override
    public List<Product> findAll() {
        return BinaryFileUtil.readFromFile(FILE_PATH);
    }

    @Override
    public void addProduct(Product product) {
        List<Product> products = findAll();
        products.add(product);
        save(products);
    }

    @Override
    public List<Product> searchByName(String keyword) {
        List<Product> results = new ArrayList<>();
        for (Product product : findAll()) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(product);
            }
        }
        return results;
    }
}
