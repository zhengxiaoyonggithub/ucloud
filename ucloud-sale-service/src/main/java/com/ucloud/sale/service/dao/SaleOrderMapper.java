package com.ucloud.sale.service.dao;

import com.ucloud.sale.service.pojo.SaleOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleOrderMapper {

    void saveOrder(SaleOrder order);
}
