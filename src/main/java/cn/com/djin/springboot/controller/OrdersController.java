package cn.com.djin.springboot.controller;

import cn.com.djin.springboot.entity.Orders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *   订单控制器
 */
@Controller
@RequestMapping("/orders")
public class OrdersController extends BaseController<Orders>{

    //去到订单支付页面
    @RequestMapping("/toPay")
    public String toPay(){
        return "alipay/ordersPay";  //转发
    }

    //订单支付完成后的路径回调（1.修改订单状态，2.生成消费记录）
    //获取订单的相关数据
    @RequestMapping("/myOrdersPay")
    public String myOrdersPay(String out_trade_no){
        try {
            return ordersService.afterOrdersPay(out_trade_no);
        } catch (Exception e) {
            e.printStackTrace();
            return "payError";
        }
    }
}
