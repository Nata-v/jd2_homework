package by.nata.annotations.database.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Embeddable
@Component
public class ContactEmployee1 implements Serializable {
    private static final long serialVersionUID = -9132807096018160850L;
    @Column(name = "number")
    private String number;
    @Column(name = "type")
    private String type;

    public ContactEmployee1() {
    }

    public ContactEmployee1(String number, String type) {
        this.number = number;
        this.type = type;
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
        return "ContactEmployee1{" +
                "number='" + number + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ContactEmployee1)) return false;
        ContactEmployee1 that = (ContactEmployee1) object;
        return Objects.equals(getNumber(), that.getNumber()) && Objects.equals(getType(), that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getType());
    }
}
