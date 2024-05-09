package xyz.solidnetwork.service.account.transaction;

import java.util.List;

public class Report {
    private String account;
    private List<Transaction> deposits;
    private List<Transaction> withdrawals;
    private List<Transaction> fees;

    public Report() {
        super();
    }

    public Report(String account, List<Transaction> deposits, List<Transaction> withdrawals,
            List<Transaction> fees) {
        this.account = account;
        this.deposits = deposits;
        this.withdrawals = withdrawals;
        this.fees = fees;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public List<Transaction> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<Transaction> deposits) {
        this.deposits = deposits;
    }

    public List<Transaction> getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(List<Transaction> withdrawals) {
        this.withdrawals = withdrawals;
    }

    public List<Transaction> getFees() {
        return fees;
    }

    public void setFees(List<Transaction> fees) {
        this.fees = fees;
    }

}
