package com.github.bbijelic.ca.api.certificate.profiles.api;

import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.models.*;

import io.swagger.models.auth.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class Bootstrap extends HttpServlet {
  @Override
  public void init(ServletConfig config) throws ServletException {
    Info info = new Info()
      .title("Swagger Server")
      .description("API for management of certificate profiles")
      .termsOfService("")
      .contact(new Contact()
        .email(""))
      .license(new License()
        .name("MIT")
        .url("https://raw.githubusercontent.com/bbijelic/certificate-authority/master/LICENSE"));

    ServletContext context = config.getServletContext();
    Swagger swagger = new Swagger().info(info);

    new SwaggerContextService().withServletConfig(config).updateSwagger(swagger);
  }
}
