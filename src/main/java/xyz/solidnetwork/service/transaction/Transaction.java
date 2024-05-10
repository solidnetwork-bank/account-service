package xyz.solidnetwork.service.transaction;

import java.time.LocalDate;

public class Transaction {
    private String id;
    private LocalDate date;
    private String desc;
    private Double amount;

    public Transaction() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction [id=" + id + ", date=" + date + ", desc=" + desc + ", amount=" + amount + "]";
    }

}
