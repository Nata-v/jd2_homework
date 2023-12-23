package by.nata.xml.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "company")
public class Company implements Serializable {
    private static final long serialVersionUID = 2296250378409793875L;

    @Id
    @GenericGenerator(strategy = "uuid", name = "company_uuid")
    @GeneratedValue(generator = "company_uuid")
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;
    @Column(name = "created_date")
    private LocalDate created_date;




    private Company() {
    }

    public Company(String id, String name, LocalDate created_date) {
        this.id = id;
        this.name = name;
        this.created_date = created_date;
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

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", created_date=" + created_date +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Company)) return false;
        Company that = (Company) object;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getCreated_date(), that.getCreated_date());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCreated_date());
    }
}
