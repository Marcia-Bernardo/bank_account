import java.util.Date;

public class Client {
    private int accountNumber;
    private String name;
    private Date birth;


    public Client(int accountNumber, String name, Date birth) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.birth = birth;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Client{" +
                "accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                '}';
    }
}
