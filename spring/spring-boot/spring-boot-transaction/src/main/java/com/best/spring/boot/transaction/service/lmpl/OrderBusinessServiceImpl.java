package com.best.spring.boot.transaction.service.lmpl;

import com.best.spring.boot.transaction.mapper.OrderMapper;
import com.best.spring.boot.transaction.model.Order;
import com.best.spring.boot.transaction.service.InnerOrderService;
import com.best.spring.boot.transaction.service.OrderBusinessService;
import com.best.spring.boot.transaction.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lnsane
 */
@Service
public class OrderBusinessServiceImpl implements OrderBusinessService {
    @Autowired
    private InnerOrderService innerOrderService;
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void save(Order order) {
        orderMapper.del();
        orderService.save(order);
        while (true) {

        }
    }
}
