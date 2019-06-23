package com.imooc.web.controller.async;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.logging.Logger;

@RestController
@RequestMapping("/order")
public class AsyncController {


    private org.slf4j.Logger logger=LoggerFactory.getLogger(getClass());

    @GetMapping
    public Callable<String> order() throws InterruptedException {
        logger.info("主线程记录开始");
        Callable<String> result=new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info("副线程记录开始");
                Thread.sleep(1000);
                logger.info("副线程记录结束");
                return "success";
            }
        };
        //Thread.sleep(1000);
        logger.info("主线程记录结束");
        return result;
    }
    /*@GetMapping
    public String order() throws InterruptedException {
        logger.info("主线程记录开始");
        Thread.sleep(1000);
        logger.info("主线程记录结束");
        return "success";
    }*/
}
