package by.nata.annotations.database.entity;

import org.hibernate.annotations.GenericGenerator;



import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "company")

public class Company1 implements Serializable {
    private static final long serialVersionUID = -4241885064074994957L;

    @Id
    @GenericGenerator(strategy = "uuid", name = "company_uuid")
    @GeneratedValue(generator = "company_uuid")
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;
    @Column(name = "created_date")
    private LocalDate created_date;

    @Embedded
    private CompanyAddress1 companyAddress1;

    public Company1() {
    }



    public Company1(String id, String name, LocalDate created_date, CompanyAddress1 companyAddress1) {
        this.id = id;
        this.name = name;
        this.created_date = created_date;
        this.companyAddress1 = companyAddress1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDate created_date) {
        this.created_date = created_date;
    }

    public CompanyAddress1 getCompanyAddress1() {
        return companyAddress1;
    }

    public void setCompanyAddress1(CompanyAddress1 companyAddress1) {
        this.companyAddress1 = companyAddress1;
    }

    @Override
    public String toString() {
        return "Company1{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", created_date=" + created_date +
                ", companyAddress1=" + companyAddress1 +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Company1)) return false;
        Company1 that = (Company1) object;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getCreated_date(), that.getCreated_date()) && Objects.equals(getCompanyAddress1(), that.getCompanyAddress1());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCreated_date(), getCompanyAddress1());
    }
}
