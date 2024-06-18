package Tenant.config.MongoConfig;

import java.io.IOException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import Tenant.config.MongoConfig.ConnectionStorage;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class TenantFilter extends OncePerRequestFilter {

  private static final String TENANT_HEADER = "X-Tenant";
  private static final String CONNECTION_STRING = "mongodb://localhost:27017/TENANT?readPreference=primary";
  private static final String TENANT_REPLACEMENT = "TENANT";

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    System.out.println("tennat filter");
    String tenantHeader = request.getHeader(TENANT_HEADER);
    System.out.println(tenantHeader);
    if (tenantHeader == null || tenantHeader.trim().isEmpty()) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      response.getWriter().write("X-Tenant header is required");
    } else {

      String dbConnectionString = CONNECTION_STRING.replace(TENANT_REPLACEMENT, tenantHeader);
      ConnectionStorage.setConnection(dbConnectionString);
      System.out.println(dbConnectionString);
      filterChain.doFilter(request, response);
      ConnectionStorage.clear();
    }
  }
}