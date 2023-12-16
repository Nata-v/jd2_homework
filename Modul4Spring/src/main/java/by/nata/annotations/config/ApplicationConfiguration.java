package by.nata.annotations.config;

import by.nata.annotations.database.entity.CompanyAddress1;
import by.nata.annotations.database.entity.Company1;
import by.nata.annotations.database.entity.ContactEmployee1;
import by.nata.annotations.database.entity.Employee1;
import org.springframework.context.annotation.*;

import java.time.LocalDate;
@Configuration
@ComponentScan(basePackages = "by.nata.annotations")
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



}
