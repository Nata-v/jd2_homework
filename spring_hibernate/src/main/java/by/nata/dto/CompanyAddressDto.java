package by.nata.dto;

import java.io.Serializable;

public class CompanyAddressDto implements Serializable {

    private  String city;
    private  String street;

    private  String postCode;

    public CompanyAddressDto() {
    }

    public CompanyAddressDto(String city, String street, String postCode) {
        this.city = city;
        this.street = street;
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
