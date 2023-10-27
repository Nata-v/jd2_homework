package by.nata.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public final class Payments implements Serializable {
    private static final long serialVersionUID = 1L;
        private final String payment_date;
        private final String recipients_id;
        private final BigDecimal amount;

    public Payments(String payment_date, String recipients_id, BigDecimal amount) {
        this.payment_date = payment_date;
        this.recipients_id = recipients_id;
        this.amount = amount;
    }

    public String getPaymentDate() {
        return payment_date;
    }

    public String getRecipientName() {
        return recipients_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "payment_date='" + payment_date + '\'' +
                ", recipients_id='" + recipients_id + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payments)) return false;
        Payments payments = (Payments) o;
        return Objects.equals(payment_date, payments.payment_date) && Objects.equals(recipients_id, payments.recipients_id) && Objects.equals(getAmount(), payments.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(payment_date, recipients_id, getAmount());
    }
}

