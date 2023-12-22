package by.nata.annotations.config;

import by.nata.annotations.database.entity.CompanyAddress1;
import by.nata.annotations.database.entity.Company1;
import by.nata.annotations.database.entity.ContactEmployee1;
import by.nata.annotations.database.entity.Employee1;

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

    public Company1 createCompany(){
        return new Company1(null, "TikTok", LocalDate.now(),
                new CompanyAddress1("Moscow", "Arbat", "389877"));
    }
    @Bean("createCompany2")
    public Company1 createCompany2(){
        return new Company1(null, "Netflix", LocalDate.now(),
                new CompanyAddress1("Minsk", "Nemiga", "333333"));
    }

    @Bean("createEmployee")
    public Employee1 createEmployee(){
        return  new Employee1(null, "Bob", "Stone", 5000.00,
                new Company1(null, "Google", LocalDate.now(),
                        new CompanyAddress1("New-York", "Manhattan", "111111")),
                new ContactEmployee1("256-44-88", "Домашний"));
    }
    @Bean("createEmployee2")
    @Primary
    public Employee1 createEmployee2(){
        return  new Employee1(null, "Mike", "Jackson", 5000.00,
                new Company1(null, "Microsoft", LocalDate.now(),
                        new CompanyAddress1("Washington", "Redmond", "555555")),
                new ContactEmployee1("111-44-11", "Домашний"));

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
