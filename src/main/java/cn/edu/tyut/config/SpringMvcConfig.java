package cn.edu.tyut.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 羊羊
 * @ClassName SpringMvcConfig
 * @SubmitTime 周五
 * @DATE 2024/1/5
 * @Time 12:24
 * @Package_Name cn.edu.tyut.config
 * @Note
 * 1.实现Springmvc组件声明标准化接口WebMvcConfigurer 提供了各种组件对应的方法
 * 2.添加配置类注解@Configuration
 * 3.添加mvc复合功能开关@EnableWebMvc
 * 4.添加controller层扫描注解
 * 5.开启默认处理器,支持静态资源处理
 */
@Configuration
@ComponentScans({
        @ComponentScan("cn.edu.tyut.controller")
})
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {
    /**
     * 开启对静态资源的访问，会放行与RequestMapping路径无关的所有静态内容
     * 相当于在SpringMVC配置文件中设置<mvc:default-servlet-handler/>
     * @param configurer 默认的Servlet处理器配置文件
     */
    @Override
    public void configureDefaultServletHandling(@NotNull DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 配置默认的视图解析器解析路径为什么
     * @param registry 视图解析器配置
     */
    @Override
    public void configureViewResolvers(@NotNull ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/admin/", ".jsp");
    }
}