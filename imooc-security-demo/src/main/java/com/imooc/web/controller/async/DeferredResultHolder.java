package com.imooc.web.controller.async;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DeferredResultHandler
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/6/24 17:22
 * @Version 1.0
 */
@Component
public class DeferredResultHolder {
    private Map<String, DeferredResult> map =new HashMap<>();

    public Map<String, DeferredResult> getMap() {
        return map;
    }

    public void setMap(Map<String, DeferredResult> map) {
        this.map = map;
    }
}
