package com.kang.shiyan02.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusPlugsConfig {

    //配置插件（不配置插件selectPage()无效）

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor()
    {
        // 定义拦截器
        MybatisPlusInterceptor mpInterceptor =new MybatisPlusInterceptor();
//               添加具体拦截器
        mpInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());

        return mpInterceptor;

    }
}
