package Tenant.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class WebConfiguration {

  @Bean
  public FilterRegistrationBean<TenantFilter> tenantFilter() {
    FilterRegistrationBean<TenantFilter> registrationBean = new FilterRegistrationBean<>();
    registrationBean.setFilter(new TenantFilter());
    registrationBean.addUrlPatterns("/api/*"); 
    registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
    return registrationBean;
  }

     @Bean
    public FilterRegistrationBean<JWTFilter> jwtFilter() {
        FilterRegistrationBean<JWTFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JWTFilter());
        registrationBean.addUrlPatterns("/api/*");
        registrationBean.setOrder(Ordered.LOWEST_PRECEDENCE); // Set lowest precedence
        return registrationBean;
    }
}