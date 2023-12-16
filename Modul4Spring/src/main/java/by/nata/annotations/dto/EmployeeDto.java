package by.nata.annotations.dto;

import by.nata.annotations.database.entity.Company1;
import by.nata.annotations.database.entity.ContactEmployee1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
@Scope(scopeName = "prototype")
public  class EmployeeDto implements Serializable {
    @Override
    public String toString() {
        return "EmployeeDto{}";
    }
}
