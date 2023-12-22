package by.nata.annotations.database.entity;

import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "employee")

public class Employee1 implements Serializable {
    private static final long serialVersionUID = 3372325038143361541L;
    @Id
    @GenericGenerator(strategy = "uuid", name = "employee_uuid")
    @GeneratedValue(generator = "employee_uuid")
    @Column(name = "id")
    private String id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "salary")
    private double salary;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")

    private Company1 company;

    @Embedded
    private ContactEmployee1 contactEmployee1;

    public Employee1() {
    }

    public Employee1(String id, String first_name, String last_name, double salary, Company1 company, ContactEmployee1 contactEmployee1) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.salary = salary;
        this.company = company;
        this.contactEmployee1 = contactEmployee1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Company1 getCompany() {
        return company;
    }

    public void setCompany(Company1 company) {
        this.company = company;
    }

    public ContactEmployee1 getContactEmployee1() {
        return contactEmployee1;
    }

    public void setContactEmployee1(ContactEmployee1 contactEmployee1) {
        this.contactEmployee1 = contactEmployee1;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "id='" + id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", salary=" + salary +
                ", company=" + company +
                ", contactEmployee1=" + contactEmployee1 +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Employee1)) return false;
        Employee1 employee1 = (Employee1) object;
        return Double.compare(employee1.getSalary(), getSalary()) == 0 && Objects.equals(getId(), employee1.getId()) && Objects.equals(getFirst_name(), employee1.getFirst_name()) && Objects.equals(getLast_name(), employee1.getLast_name()) && Objects.equals(getCompany(), employee1.getCompany()) && Objects.equals(getContactEmployee1(), employee1.getContactEmployee1());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirst_name(), getLast_name(), getSalary(), getCompany(), getContactEmployee1());
    }
}
