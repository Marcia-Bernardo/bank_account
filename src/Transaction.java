import java.util.Date;

public class Transaction {

    private String type;
    private Date date;
    private double value;
    private int recipientAccountNumber;


    public Transaction(String type, Date date, double value, int numberAcoount) {
        this.type = type;
        this.date = date;
        this.value = value;
        this.recipientAccountNumber = numberAcoount;
    }

    public Transaction(String type, Date date, double value) {
        this.type = type;
        this.date = date;
        this.value = value;
    }

    public int getRecipientAccountNumber() {
        return recipientAccountNumber;
    }

    public void setRecipientAccountNumber(int recipientAccountNumber) {
        this.recipientAccountNumber = recipientAccountNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", date='" + date + '\'' +
                ", value=" + value +
                '}';
    }
}
