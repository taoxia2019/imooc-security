package com.imooc.security.browser;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName BrowserSecurityController
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/6/25 16:17
 * @Version 1.0
 */
@RestController
public class BrowserSecurityController {

    @RequestMapping("/authentication/require")
    public String requireAuthentication(HttpServletRequest request, HttpServletResponse response){
        return null;
    }
}
