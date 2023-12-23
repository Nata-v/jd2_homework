package by.nata.annotations.database.entity;

import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Component
public class NewEmployee {


    private String first_name;

    private String last_name;

    private double salary;

    private NewCompany company;

    public NewEmployee(String first_name, String last_name, double salary, NewCompany company) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.salary = salary;
        this.company = company;
    }

    public NewEmployee() {
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public NewCompany getCompany() {
        return company;
    }

    public void setCompany(NewCompany company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "NewEmployee{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", salary=" + salary +
                ", company=" + company +
                '}';
    }
}
