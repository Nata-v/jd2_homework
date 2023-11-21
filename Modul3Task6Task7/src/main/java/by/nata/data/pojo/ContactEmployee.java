package by.nata.data.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Embeddable

public class ContactEmployee implements Serializable {
    private static final long serialVersionUID = 2417458733188069477L;

    private String number;
    private String type;

    public ContactEmployee() {
    }

    public ContactEmployee( String number, String type) {
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
        return "ContactEmployee{" +
                "number='" + number + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactEmployee)) return false;
        ContactEmployee that = (ContactEmployee) o;
        return Objects.equals(getNumber(), that.getNumber()) && Objects.equals(getType(), that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getType());
    }
}
