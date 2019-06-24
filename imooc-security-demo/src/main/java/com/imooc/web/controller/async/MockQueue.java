package com.imooc.web.controller.async;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName MockQueue
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/6/24 17:10
 * @Version 1.0
 */
@Component
public class MockQueue {

    private org.slf4j.Logger logger= LoggerFactory.getLogger(getClass());
    private String placeOrder;
    private String completeOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder) throws InterruptedException {
        new Thread(
                ()->{
                    logger.info("接到下单请求，"+placeOrder);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.completeOrder = placeOrder;
                    logger.info("下单请求处理完毕，"+placeOrder);
                }
        ).start();

    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
