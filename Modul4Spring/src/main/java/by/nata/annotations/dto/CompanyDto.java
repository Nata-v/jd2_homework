package by.nata.annotations.dto;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

public final class CompanyDto implements Serializable {
    @Override
    public String toString() {
        return "CompanyDto{}";
    }

    public CompanyDto() {
    }
}
