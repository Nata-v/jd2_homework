package by.nata.data.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "student")
public class Student extends Person implements Serializable {
    private static final long serialVersionUID = -1709784433631785883L;
    @Column(name = "faculty")
    private String faculty;
    @Column(name = "mark")
    private Double mark;

    public Student() {

    }

    public Student(Long id, String name, String surname, String faculty, Double mark) {
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
        return "Student{" +
                "faculty='" + faculty + '\'' +
                ", mark=" + mark +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Student)) return false;
        if (!super.equals(object)) return false;
        Student student = (Student) object;
        return Objects.equals(getFaculty(), student.getFaculty()) && Objects.equals(getMark(), student.getMark());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFaculty(), getMark());
    }
}
