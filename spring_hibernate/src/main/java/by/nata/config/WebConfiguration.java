package by.nata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@ComponentScan(basePackages = "by.nata")
@EnableWebMvc

public class WebConfiguration implements WebMvcConfigurer {
    @Bean
    @SuppressWarnings("unused")
    public InternalResourceViewResolver internalResourceViewResolver(){

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        //resolver.setSuffix(".html");
        return resolver;

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("*.html")
                .addResourceLocations("/");
        registry.addResourceHandler("/static/img/*.jpg")
                .addResourceLocations("/static/img/");
        registry.addResourceHandler("/static/img/*.png")
                .addResourceLocations("/static/img/");
        registry.addResourceHandler("/static/img/*.mp4")
                .addResourceLocations("/static/img/");
    }




    @Bean
    @SuppressWarnings("unused")
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
}
