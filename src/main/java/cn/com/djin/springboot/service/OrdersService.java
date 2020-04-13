package cn.com.djin.springboot.service;

import cn.com.djin.springboot.entity.Orders;

/**
 *   订单业务层接口
 */
public interface OrdersService extends BaseService<Orders>{

    //支付成功之后的操作（1.修改订单状态，2.生成消费记录）
    String afterOrdersPay(String out_trade_no) throws Exception;

}
