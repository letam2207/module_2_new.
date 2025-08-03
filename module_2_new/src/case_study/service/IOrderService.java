package case_study.service;

import case_study.entity.Order;
import java.util.List;

public interface IOrderService {
    void add(Order order);              
    List<Order> findAll();
}
