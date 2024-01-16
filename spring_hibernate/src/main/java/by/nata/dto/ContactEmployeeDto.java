package by.nata.dto;

import jakarta.persistence.Column;

import java.io.Serializable;

public class ContactEmployeeDto implements Serializable {

    private String number;

    private String type;

    public ContactEmployeeDto() {
    }

    public ContactEmployeeDto(String number, String type) {
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
}
