package by.nata.annotations.database.entity;



import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class NewCompany {

    private String name;
    private LocalDate createdDate;

    public NewCompany(String name, LocalDate createdDate) {
        this.name = name;
        this.createdDate = createdDate;
    }

    public NewCompany() {
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "NewCompany{" +
                "name='" + name + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
