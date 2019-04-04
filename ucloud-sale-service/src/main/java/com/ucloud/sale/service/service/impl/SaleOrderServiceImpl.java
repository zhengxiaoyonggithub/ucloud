package com.ucloud.sale.service.service.impl;

import com.ucloud.sale.service.dao.SaleOrderMapper;
import com.ucloud.sale.service.pojo.SaleOrder;
import com.ucloud.sale.service.service.SaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleOrderServiceImpl implements SaleOrderService {

    @Autowired
    private SaleOrderMapper saleOrderMapper;


    @Override
    public void saveOrder(SaleOrder order) {
        saleOrderMapper.saveOrder(order);
    }
}
