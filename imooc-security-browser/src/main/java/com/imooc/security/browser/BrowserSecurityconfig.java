package com.imooc.security.browser;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName BrowserSecurityconfig
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/6/25 8:32
 * @Version 1.0
 */
@Configuration
public class BrowserSecurityconfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder getpassword(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
            .loginPage("/imooc-signIn.html")
            .loginProcessingUrl("/authentication/form")
            .and()
            .authorizeRequests()
            .antMatchers("/imooc-signIn.html").permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .csrf().disable();
    }


}
