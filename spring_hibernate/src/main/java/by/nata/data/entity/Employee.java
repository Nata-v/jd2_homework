package by.nata.data.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GenericGenerator(strategy = "uuid", name = "employee_uuid")
    @GeneratedValue(generator = "employee_uuid")
    @Column(name = "id")
    private String id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
   // @NotBlank(message = "Last name cannot be empty")
    private String last_name;
    @Column(name = "salary")
    private double salary;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")

    //@Qualifier("createCompany2")
    private Company company;

//    @Embedded
//    private ContactEmployee contactEmployee;

    public Employee() {
    }

    public Employee(String id, String first_name, String last_name, double salary, Company company) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.salary = salary;
        this.company = company;
       // this.contactEmployee = contactEmployee;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

//    public ContactEmployee getContactEmployee() {
//        return contactEmployee;
//    }
//
//    public void setContactEmployee(ContactEmployee contactEmployee) {
//        this.contactEmployee = contactEmployee;
//    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Employee employee)) return false;
        return Double.compare(employee.getSalary(), getSalary()) == 0 && Objects.equals(getId(), employee.getId()) && Objects.equals(getFirst_name(), employee.getFirst_name()) && Objects.equals(getLast_name(), employee.getLast_name()) && Objects.equals(getCompany(), employee.getCompany());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirst_name(), getLast_name(), getSalary(), getCompany());
    }
}
