package by.nata.annotations.database.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;


@Embeddable


public class CompanyAddress1 implements Serializable {

    private static final long serialVersionUID = 8266943103204690870L;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "post_code")
    private String postCode;

    public CompanyAddress1() {
    }

    public CompanyAddress1(String city, String street, String postCode) {
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
        return "CompanyAddress1{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof CompanyAddress1)) return false;
        CompanyAddress1 that = (CompanyAddress1) object;
        return Objects.equals(getCity(), that.getCity()) && Objects.equals(getStreet(), that.getStreet()) && Objects.equals(getPostCode(), that.getPostCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getPostCode());
    }
}
