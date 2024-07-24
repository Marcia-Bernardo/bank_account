import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {

    private int number;
    private double balance;
    private boolean isActive = true;
    private List<Transaction> transactionLists = new ArrayList<>();

    public Account(double balance, int number) {
        this.balance = balance;
        this.number = number;
    }

    public boolean addTransaction(Transaction transaction) {

        switch (transaction.getType()) {
            case "transfer":
                if (number != transaction.getRecipientAccountNumber()) {
                    if (balance >= transaction.getValue()) {
                        balance = balance - transaction.getValue();
                        transactionLists.add(transaction);
                        return true;
                    }
                } else {
                    balance = balance + transaction.getValue();
                    transactionLists.add(transaction);
                    return true;
                }
                break;
            case "withdraw":
                if (balance >= transaction.getValue()) {
                    balance = balance - transaction.getValue();
                    transactionLists.add(transaction);
                    return true;
                }
                break;
            case "deposit":
                balance = balance + transaction.getValue();
                transactionLists.add(transaction);
                return true;
        }
        return false;
    }

    public List<Transaction> getTransactionLists() {
        return transactionLists;
    }

    public List<Transaction> getTransactionByDate(Date dateStart, Date dateEnd) {
        List<Transaction> transactions = new ArrayList<>();

        for (int i = 0; i < transactionLists.size(); i++) {
            if (transactionLists.get(i).getDate().compareTo(dateStart) >= 0 && transactionLists.get(i).getDate().compareTo(dateEnd) <= 0) {
                transactions.add(transactionLists.get(i));
            }
        }
        return transactions;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return number;
    }

    public void setAccountNumber(int accountNumber) {
        this.number = accountNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

