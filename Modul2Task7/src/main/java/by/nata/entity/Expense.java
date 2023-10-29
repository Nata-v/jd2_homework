package by.nata.entity;

import java.io.Serializable;
import java.util.Objects;


public class Expense implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String paymentDate;
    private int receiverId;
    private double amount;

    public Expense(String s, int i, double v) {
    }

    public Expense(int id, String paymentDate, int receiverId, double amount) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.receiverId = receiverId;
        this.amount = amount;
    }



    public int getId() {
        return id;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public double getAmount() {
        return amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", paymentDate='" + paymentDate + '\'' +
                ", receiverId=" + receiverId +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expense)) return false;
        Expense expense = (Expense) o;
        return getId() == expense.getId() && getReceiverId() == expense.getReceiverId() && Double.compare(expense.getAmount(), getAmount()) == 0 && Objects.equals(getPaymentDate(), expense.getPaymentDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPaymentDate(), getReceiverId(), getAmount());
    }
}

