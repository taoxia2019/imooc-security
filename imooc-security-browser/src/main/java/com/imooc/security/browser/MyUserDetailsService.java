package com.imooc.security.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyUserDetailsService
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/6/25 14:53
 * @Version 1.0
 */
@Component
public class MyUserDetailsService implements UserDetailsService{
    @Autowired
    private PasswordEncoder passwordEncoder;
    private Logger logger= LoggerFactory.getLogger(getClass());
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info(username);
        String password=passwordEncoder.encode("123456");
        logger.info(password);
        return new User(username,password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
