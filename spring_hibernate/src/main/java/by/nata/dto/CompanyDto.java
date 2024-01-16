package by.nata.dto;

import by.nata.data.entity.CompanyAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

public  class CompanyDto implements Serializable {
    private  String id;


    private  String name;

    private  LocalDate created_date;


    private  CompanyAddress companyAddress;


    public CompanyDto() {
    }

    public CompanyDto(String id, String name, LocalDate created_date, CompanyAddress companyAddress) {
        this.id = id;
        this.name = name;
        this.created_date = created_date;
        this.companyAddress = companyAddress;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getCreated_date() {
        return created_date;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreated_date(LocalDate created_date) {
        this.created_date = created_date;
    }

    public CompanyAddress getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(CompanyAddress companyAddress) {
        this.companyAddress = companyAddress;
    }
}
