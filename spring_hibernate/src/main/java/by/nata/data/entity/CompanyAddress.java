package by.nata.data.entity;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class CompanyAddress {
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
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof CompanyAddress that)) return false;
        return Objects.equals(getCity(), that.getCity()) && Objects.equals(getStreet(), that.getStreet()) && Objects.equals(getPostCode(), that.getPostCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getPostCode());
    }

    @Override
    public String toString() {
        return "CompanyAddress{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
