package by.nata.data.pojo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
@DiscriminatorValue("employee")
public class SingleTableEmployee extends SingleTablePerson implements Serializable {
    private static final long serialVersionUID = -2758682166643275054L;
    @Column(name = "company")
    private String company;
    @Column(name = "salary")
    private Double salary;

    public SingleTableEmployee() {
    }



    public SingleTableEmployee(Long id, String name, String surname, String company, Double salary) {
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
        return "SingleTableEmployee{" +
                "company='" + company + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof SingleTableEmployee)) return false;
        SingleTableEmployee that = (SingleTableEmployee) object;
        return Objects.equals(getCompany(), that.getCompany()) && Objects.equals(getSalary(), that.getSalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCompany(), getSalary());
    }
}
