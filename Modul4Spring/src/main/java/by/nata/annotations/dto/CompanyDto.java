package by.nata.annotations.dto;

import by.nata.annotations.database.entity.CompanyAddress1;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope(scopeName = "prototype")
public final class CompanyDto implements Serializable {
    @Override
    public String toString() {
        return "CompanyDto{}";
    }
}
