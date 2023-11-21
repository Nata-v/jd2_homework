package by.nata.data.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "student_join")
public class JoinedTableStudent extends JoinedTablePerson implements Serializable {
    private static final long serialVersionUID = -8519029195142424390L;

    @Column(name = "faculty")
    private String faculty;
    @Column(name = "mark")
    private Double mark;

    public JoinedTableStudent() {
    }

    public JoinedTableStudent(Long id, String name, String surname, String faculty, Double mark) {
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
        return "JoinedTableStudent{" +
                "faculty='" + faculty + '\'' +
                ", mark=" + mark +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof JoinedTableStudent)) return false;
        JoinedTableStudent that = (JoinedTableStudent) object;
        return Objects.equals(getFaculty(), that.getFaculty()) && Objects.equals(getMark(), that.getMark());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFaculty(), getMark());
    }
}
