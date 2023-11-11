package by.nata.data.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

    @Entity
    @Table(name = "expenses")
    public class Expenses implements Serializable {

        private static final long serialVersionUID = -3157765322365204033L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "payment_date", nullable = false)
        private LocalDate paymentDate;


        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "receivers_id",nullable = false )
        private Receivers receivers;

        @Column(name = "amount")
        private Double amount;

        public Expenses() {
        }

        public Expenses(Long id, LocalDate paymentDate, Receivers receivers, Double amount) {
            this.id = id;
            this.paymentDate = paymentDate;
            this.receivers = receivers;
            this.amount = amount;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public LocalDate getPaymentDate() {
            return paymentDate;
        }

        public void setPaymentDate(LocalDate paymentDate) {
            this.paymentDate = paymentDate;
        }

        public Receivers getReceivers() {
            return receivers;
        }

        public void setReceivers(Receivers receivers) {
            this.receivers = receivers;
        }

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Expenses{" +
                    "id=" + id +
                    ", paymentDate=" + paymentDate +
                    ", receivers=" + receivers +
                    ", amount=" + amount +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Expenses)) return false;
            Expenses expenses = (Expenses) o;
            return Objects.equals(getId(), expenses.getId()) && Objects.equals(getPaymentDate(), expenses.getPaymentDate()) && Objects.equals(getReceivers(), expenses.getReceivers()) && Objects.equals(getAmount(), expenses.getAmount());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getPaymentDate(), getReceivers(), getAmount());
        }
    }


