package by.nata.data.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "person_join")
public abstract class JoinedTablePerson implements Serializable {
    private static final long serialVersionUID = 23709787455776390L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;

    public JoinedTablePerson() {
    }

    public JoinedTablePerson(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "JoinedTablePerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof JoinedTablePerson)) return false;
        JoinedTablePerson that = (JoinedTablePerson) object;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getSurname(), that.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname());
    }
}
