package by.nata.xml.entity;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Accounts {
    private int id;
    private String accountNumber;
    private Double amount;
    private ZonedDateTime createdDate;

    public Accounts(int id, String accountNumber, Double amount, ZonedDateTime createdDate) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.createdDate = createdDate;
    }

    public Accounts() {
    }

    public static Accounts createAccounts(int id, String accountNumber, Double amount, ZonedDateTime createdDate){
        return  new Accounts(1, "567890432",100000.00,
                ZonedDateTime.of(2023, 12, 25, 13, 00, 20, 00, ZoneId.systemDefault()));
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", amount=" + amount +
                ", createdDate=" + createdDate +
                '}';
    }
}
