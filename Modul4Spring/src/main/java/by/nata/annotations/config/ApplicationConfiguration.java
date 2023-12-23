package by.nata.annotations.config;

import by.nata.annotations.database.entity.*;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "by.nata.annotations")
@PropertySource(value = {
        "classpath:liquibase.properties",
        "classpath:hibernate.properties"
})
public class ApplicationConfiguration {

    @Bean("createCompany")
    @Primary

    public NewCompany createCompany(){
        return new NewCompany( "TikTok", LocalDate.now());
    }
    @Bean("createCompany2")
    public NewCompany createCompany2(){
        return new NewCompany("Netflix", LocalDate.now());
    }

    @Bean("createEmployee")
    public NewEmployee createEmployee(){
        return  new NewEmployee("Bob", "Stone", 5000.00,
                new NewCompany( "Google", LocalDate.now()));
    }
    @Bean("createEmployee2")
    @Primary
    public NewEmployee createEmployee2(){
        return  new NewEmployee( "Mike", "Jackson", 5000.00,
                new NewCompany( "Microsoft", LocalDate.now()));

    }

    @Bean
    public Properties hibernateProperties(
            @Value("${hibernate.show_sql}") String showSql,
            @Value("true") String debug,
            @Value("${hibernate.dialect}") String dialect
    ) {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.show_sql", showSql);
        hibernateProperties.put("debug", debug);
        hibernateProperties.put("hibernate.dialect", dialect);
        return hibernateProperties;
    }

    @Bean
    public DataSource dataSource(
            @Value("${url}") String url,
            @Value("${driver}") String driverClassName,
            @Value("user") String userName,
            @Value("${password}") String password,
            @Value("50") int maxTotal) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setDriverClassName(driverClassName);
        config.setUsername(userName);
        config.setPassword(password);
        config.setMaximumPoolSize(maxTotal);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        return new HikariDataSource(config);
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource,
                                                  @Qualifier("hibernateProperties") Properties hibernateProperties) {
        LocalSessionFactoryBean sessionFactory =
                new LocalSessionFactoryBean();

        sessionFactory.setHibernateProperties(hibernateProperties);
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setAnnotatedClasses(
                Company1.class,
                CompanyAddress1.class,
                ContactEmployee1.class,
                Employee1.class
        );
        return sessionFactory;
    }

}
