package by.nata.dto;

import by.nata.data.entity.CompanyAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

public final class CompanyDto implements Serializable {
    private final String id;


    private final String name;

    private final LocalDate created_date;


    private final CompanyAddress companyAddress;

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

    public CompanyAddress getCompanyAddress() {
        return companyAddress;
    }
}
