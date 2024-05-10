package xyz.solidnetwork.service.transaction;

import java.util.List;

public class Report {
    private String account;
    private List<Transaction> deposits;
    private List<Transaction> withdrawals;
    private List<Transaction> fees;

    public Report() {
        super();
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

    @Override
    public String toString() {
        return "Report [account=" + account + ", deposits=" + toString(deposits) + ", withdrawals="
                + toString(withdrawals) + ", fees="
                + toString(fees) + "]";
    }

    private String toString(List<Transaction> list) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (Transaction transaction : list) {
            stringBuffer.append(transaction.toString());
            stringBuffer.append(", ");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

}
