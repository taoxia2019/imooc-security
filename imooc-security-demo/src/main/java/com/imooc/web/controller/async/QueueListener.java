package com.imooc.web.controller.async;

import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @ClassName QueueListener
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/6/24 17:39
 * @Version 1.0
 */
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MockQueue mockQueue;
    @Autowired
    private DeferredResultHolder deferredResultHolder;

    private org.slf4j.Logger logger= LoggerFactory.getLogger(getClass());
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        new Thread(()->{
            while (true){
                if(StringUtils.isNotBlank(mockQueue.getCompleteOrder())){
                    String orderNumber =mockQueue.getCompleteOrder();
                    logger.info("订单处理完成结果："+orderNumber);
                    deferredResultHolder.getMap().get(orderNumber).setResult("place order success.");
                    mockQueue.setCompleteOrder(null);
                }else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
