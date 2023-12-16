package by.nata.xml.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Embeddable
public class ContactEmployee implements Serializable {
    private static final long serialVersionUID = -3200572993909694759L;
    @Column(name = "number")
    private String number;
    @Column(name = "type")
    private String type;

    public ContactEmployee() {
    }

    public ContactEmployee(String number, String type) {
        this.number = number;
        this.type = type;
    }

    public void initMethod(){
        System.out.println("Init ContactEmployee");
    }

    public void destroyMethod(){
        System.out.println("Destroy ContactEmployee");
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ContactEmployee{" +
                "number='" + number + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ContactEmployee)) return false;
        ContactEmployee that = (ContactEmployee) object;
        return Objects.equals(getNumber(), that.getNumber()) && Objects.equals(getType(), that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getType());
    }
}
