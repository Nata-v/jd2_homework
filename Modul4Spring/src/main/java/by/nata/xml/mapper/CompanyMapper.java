package by.nata.xml.mapper;

import by.nata.xml.dto.CompanyDto;

public class CompanyMapper {
    private final CompanyDto companyDto;

    public CompanyMapper(CompanyDto companyDto) {
        this.companyDto = companyDto;
    }

    @Override
    public String toString() {
        return "CompanyMapper{" +
                "companyDto=" + companyDto +
                '}';
    }
}
