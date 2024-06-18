package Tenant.config.MongoConfig;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
@RequiredArgsConstructor
public class WebConfiguration {

  private final JWTFilter jwtFilter;
  private final TenantFilter tenantFilter;

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
    registrationBean.setFilter(jwtFilter);
    registrationBean.addUrlPatterns("/api/*");
    registrationBean.setOrder(Ordered.LOWEST_PRECEDENCE); // Set lowest precedence
    return registrationBean;
  }
}