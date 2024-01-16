package by.nata.data.entity;

import org.hibernate.annotations.GenericGenerator;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "company")
public class Company {


        @Id
        @GenericGenerator(strategy = "uuid", name = "company_uuid")
        @GeneratedValue(generator = "company_uuid")
        @Column(name = "id")
        private String id;

        @Column(name = "name")
        private String name;
        @Column(name = "created_date")
        private LocalDate created_date;

//        @Embedded
//        private CompanyAddress companyAddress;

        public Company() {
        }

        public Company(String id, String name, LocalDate created_date) {
                this.id = id;
                this.name = name;
                this.created_date = created_date;
               // this.companyAddress = companyAddress;
        }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public LocalDate getCreated_date() {
                return created_date;
        }

//        public CompanyAddress getCompanyAddress() {
//                return companyAddress;
//        }
//
//        public void setCompanyAddress(CompanyAddress companyAddress) {
//                this.companyAddress = companyAddress;
//        }

        public void setCreated_date(LocalDate created_date) {
                this.created_date = created_date;
        }

        @Override
        public boolean equals(Object object) {
                if (this == object) return true;
                if (!(object instanceof Company company)) return false;
                return Objects.equals(getId(), company.getId()) && Objects.equals(getName(), company.getName()) && Objects.equals(getCreated_date(), company.getCreated_date());
        }

        @Override
        public int hashCode() {
                return Objects.hash(getId(), getName(), getCreated_date());
        }
}
