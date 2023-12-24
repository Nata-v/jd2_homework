package by.nata.dto;

import by.nata.data.entity.Company;
import by.nata.data.entity.ContactEmployee;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.Serializable;

public final class EmployeeDto implements Serializable {
    private final String id;

    private final String first_name;

    private final String last_name;

    private final double salary;

    private final Company company;

    private final ContactEmployee contactEmployee;

    public EmployeeDto(String id, String first_name, String last_name, double salary, Company company, ContactEmployee contactEmployee) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.salary = salary;
        this.company = company;
        this.contactEmployee = contactEmployee;
    }

    public String getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public double getSalary() {
        return salary;
    }

    public Company getCompany() {
        return company;
    }

    public ContactEmployee getContactEmployee() {
        return contactEmployee;
    }
}
