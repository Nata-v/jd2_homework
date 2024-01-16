package by.nata.config;

import jakarta.servlet.*;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


import java.util.Set;

public class WebInitializer implements ServletContainerInitializer{
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        context.register(ApplicationConfiguration.class);
        context.register(WebConfiguration.class);



        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        final ServletRegistration.Dynamic servletRegistration =
                ctx.addServlet("dispatcherServlet", dispatcherServlet);
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/");


        long maxSize = 10L * 1024 * 1024 * 1024;
        servletRegistration.setMultipartConfig(new MultipartConfigElement(null,
                maxSize, maxSize, 0));
    }
}
