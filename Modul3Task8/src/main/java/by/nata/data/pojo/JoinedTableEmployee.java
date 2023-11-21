package by.nata.data.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "employee_join")
public class JoinedTableEmployee extends JoinedTablePerson implements Serializable {
    private static final long serialVersionUID = -8950300687781714067L;
    @Column(name = "company")
    private String company;
    @Column(name = "salary")
    private Double salary;

    public JoinedTableEmployee() {
    }

    public JoinedTableEmployee(Long id, String name, String surname, String company, Double salary) {
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
        return "JoinedTableEmployee{" +
                "company='" + company + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof JoinedTableEmployee)) return false;
        JoinedTableEmployee that = (JoinedTableEmployee) object;
        return Objects.equals(getCompany(), that.getCompany()) && Objects.equals(getSalary(), that.getSalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCompany(), getSalary());
    }
}
