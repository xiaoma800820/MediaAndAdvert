package com.xiaoma;

import com.xiaoma.filter.AndroidIOSFilter;
import com.xiaoma.filter.BackFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.servlet.Filter;


/**
 * 程序运行加载入口
 * @author mmh
 */
@EnableScheduling
@ComponentScan(basePackages = "com.xiaoma")
@MapperScan("com.xiaoma.dao")
@SpringBootApplication
public class ReaderApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(ReaderApplication.class, args);
    }


    /**
     * Configure the application. Normally all you would need to do is to add sources
     * (e.g. config classes) because other settings have sensible defaults. You might
     * choose (for instance) to add default command line arguments, or set an active
     * Spring profile.
     *
     * @param builder a builder for the application context
     * @return the application builder
     * @see SpringApplicationBuilder
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ReaderApplication.class);
    }
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(backFilter());
        registration.addUrlPatterns("/api/reader/back/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("backFilter");
        return registration;
    }


    @Bean(name = "backFilter")
    public Filter backFilter() {
        return new BackFilter();
    }


    /**
     * 配置附属过滤器
     * @return 注册过滤器对象
     */
    @Bean
    public FilterRegistrationBean someFilterRegistration1() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(androidFilter());
        registration.addUrlPatterns("/api/reader/media/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("androidFilter");
        return registration;
    }
    @Bean(name = "androidFilter")
    public Filter androidFilter() {
        return new AndroidIOSFilter();
    }
}
