package com.pyk.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by 彭义凯 on 2019/12/1.
 */
@Configuration
public class WebConfigure implements WebMvcConfigurer {

    @Autowired
    private LoginFilter loginFilter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginFilter).
                addPathPatterns("/depot*").
                excludePathPatterns("/depot/getLogin");
    }
}
