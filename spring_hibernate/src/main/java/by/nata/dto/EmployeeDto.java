package by.nata.dto;

import by.nata.data.entity.Company;
import by.nata.data.entity.ContactEmployee;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.Serializable;

public  class EmployeeDto implements Serializable {
    private  String id;

    private  String first_name;

    private  String last_name;

    private double salary;

    private  Company company;

    private  ContactEmployee contactEmployee;

    public EmployeeDto() {
    }

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

    public void setId(String id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setContactEmployee(ContactEmployee contactEmployee) {
        this.contactEmployee = contactEmployee;
    }
}
