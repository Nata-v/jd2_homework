package by.nata.data.pojo;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Embeddable

public class CompanyAddress implements Serializable {
    private static final long serialVersionUID = -406602240965639115L;

    private String city;
    private String street;

    private String postCode;

    public CompanyAddress() {
    }

    public CompanyAddress(String city, String street, String postCode) {
        this.city = city;
        this.street = street;
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "CompanyAddress{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanyAddress)) return false;
        CompanyAddress that = (CompanyAddress) o;
        return Objects.equals(getCity(), that.getCity()) && Objects.equals(getStreet(), that.getStreet()) && Objects.equals(getPostCode(), that.getPostCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getPostCode());
    }
}
