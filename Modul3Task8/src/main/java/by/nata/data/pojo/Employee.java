package by.nata.data.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "employee")

public class Employee extends Person implements Serializable {
    private static final long serialVersionUID = -6922337090377798041L;
    @Column(name = "company")
    private String company;
    @Column(name = "salary")
    private Double salary;

    public Employee() {

    }


    public Employee(Long id, String name, String surname, String company, Double salary) {
        super(id, name, surname);
        this.company = company;
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "company='" + company + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Employee)) return false;
        if (!super.equals(object)) return false;
        Employee employee = (Employee) object;
        return Objects.equals(getCompany(), employee.getCompany()) && Objects.equals(getSalary(), employee.getSalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCompany(), getSalary());
    }
}
