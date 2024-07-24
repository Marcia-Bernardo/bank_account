import java.util.ArrayList;
import java.util.List;

public class Agency {

    private List<Account> accounts = new ArrayList<>();

    private int number;
    private String location;

    public Agency(String location, int number) {
        this.location = location;
        this.number = number;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Account getAccount(int number) {
        int index = 0;

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == number) {
                index = i;
            }
        }
        return accounts.get(index);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
