package com.best.spring.boot.transaction.service.lmpl;

import com.best.spring.boot.transaction.model.Order;
import com.best.spring.boot.transaction.service.InnerOrderService;
import com.best.spring.boot.transaction.service.OrderBusinessService;
import com.best.spring.boot.transaction.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lnsane
 */
@Service
public class OrderBusinessServiceImpl implements OrderBusinessService {
    @Autowired
    private InnerOrderService innerOrderService;
    @Autowired
    private OrderService orderService;

    @Override
    public void save(Order order) {
        orderService.save(order);
        innerOrderService.save2();
        if (1 / 0 == 1) {

        }
    }
}
