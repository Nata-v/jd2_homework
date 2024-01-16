package by.nata.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

//@Embeddable
public class ContactEmployee {
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
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ContactEmployee that)) return false;
        return Objects.equals(getNumber(), that.getNumber()) && Objects.equals(getType(), that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getType());
    }

    @Override
    public String toString() {
        return "ContactEmployee{" +
                "number='" + number + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
