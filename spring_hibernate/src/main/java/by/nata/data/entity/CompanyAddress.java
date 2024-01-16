package by.nata.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

//@Embeddable
public class CompanyAddress {
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
@Column(name = "postCode")
    private String postCode;

    public CompanyAddress() {
    }

    public CompanyAddress( String city,String street, String postCode) {
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


}
