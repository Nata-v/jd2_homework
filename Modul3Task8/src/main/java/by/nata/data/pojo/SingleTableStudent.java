package by.nata.data.pojo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
@DiscriminatorValue("student")

public class SingleTableStudent extends SingleTablePerson implements Serializable {
    private static final long serialVersionUID = 64641196820984814L;
    @Column(name = "faculty")
    private String faculty;
    @Column(name = "mark")
    private Double mark;

    public SingleTableStudent() {
    }



    public SingleTableStudent(Long id, String name, String surname, String faculty, Double mark) {
        super(id, name, surname);
        this.faculty = faculty;
        this.mark = mark;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "SingleTableStudent{" +
                "faculty='" + faculty + '\'' +
                ", mark=" + mark +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof SingleTableStudent)) return false;
        SingleTableStudent that = (SingleTableStudent) object;
        return Objects.equals(getFaculty(), that.getFaculty()) && Objects.equals(getMark(), that.getMark());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFaculty(), getMark());
    }
}
