package scau.nan.core.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    /**
     * The annotation here is to let spring inject the properties in the application.yml
     * into the DruidDataSource class and manage it.
     * DataSource is an interface and DruidDataSource is a class which implements it.
     * <author> Wu nan </author>
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid() {
        return new DruidDataSource();
    }

    /**
     * 配置druid监控
     * 配置一个管理后台的servlet
     * 访问地址：http://localhost:8080/druid/
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
        // I add <StatViewServlet> because idea will warn.
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String, String> initParameters = new HashMap<>();
        // 参考属性见：com.alibaba.druid.support.http.ResourceServlet
        initParameters.put("loginUsername", "admin"); // druid监控登录用户名
        initParameters.put("loginPassword", "123456");// druid监控登录密码
        initParameters.put("allow", ""); // 默认允许所有
        initParameters.put("deny", ""); // 黑名单
        bean.setInitParameters(initParameters);
        return bean;
    }

    /**
     * 配置一个web监控的filter
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter() {
        FilterRegistrationBean<WebStatFilter> filterBean = new FilterRegistrationBean<>();
        filterBean.setFilter(new WebStatFilter());
        // Suggest given by idea.
        filterBean.setUrlPatterns(Collections.singletonList("/*"));
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("exclusions", "*.js,*.css,/druid/*");//参考属性见：com.alibaba.druid.support.http.WebStatFilter
        filterBean.setInitParameters(initParameters);
        return filterBean;
    }


}
