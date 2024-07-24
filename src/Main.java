import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Bank bank = new Bank("Mill");
    static Agency agency = new Agency("Lisbon", 1);

    public static void main(String[] args) throws ParseException, IOException {


        bank.addAgency(agency);
        Account account = new Account(123, 1);
        Account account1 = new Account(124, 2);

        agency.addAccount(account);
        agency.addAccount(account1);

//        Transaction transaction = new Transaction("Transfer", formatter.parse("23-07-2024"), 350, 3);
//        account.addTransaction(transaction);
        menu();
    }

    private static void menu() throws IOException, ParseException {
        int option;
        int accountNum;
        Account userAccount;

        do {

            accountNum = Integer.parseInt(readValue("Account number: "));


            userAccount = agency.getAccount(accountNum);


        } while (userAccount == null);

        do {
            System.out.println("\nChoose an option");
            System.out.println("1. Withdraw");
            System.out.println("2. Transfer");
            System.out.println("3. Extract");
            System.out.println("4. Current balance");
            System.out.println("5. Cancel account");
            System.out.println("0. End");

            option = Integer.parseInt(readValue(""));

            switch (option) {

                case 1:
                    withdraw(userAccount);
                    break;
                case 2:
                    transfer(userAccount);
                    break;
                case 3:
                    extract(userAccount);
                    break;
                case 4:
                    System.out.println(userAccount.getBalance());
                    break;
                case 5:
                    cancelAccount(userAccount);
                    break;
                default:
                    System.out.println("Option wrong");
            }
        } while (option != 0);
    }

    private static String readValue(String message) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println(message);
        return reader.readLine();
    }

    private static void withdraw(Account userAccount) throws IOException, ParseException {
        double valueToAdd;

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

        valueToAdd = Double.parseDouble(readValue("Value to remove: "));
        Transaction transaction = new Transaction("withdraw", formatter.parse("24-07-2024"), valueToAdd);
        boolean wasInserted = userAccount.addTransaction(transaction);
        if (wasInserted) {
            System.out.println("Successfully inserted");
        } else {
            System.out.println("Insufficient funds");
        }
    }

    private static void transfer(Account userAccount) throws IOException, ParseException {
        int countNumberInsert;

        countNumberInsert = Integer.parseInt(readValue("Insert the account number for transfer: "));

        Account repositoryAccount = agency.getAccount(countNumberInsert);

        if (repositoryAccount == null) {
            System.out.println("The account number is wrong! ");
            return;
        }

        double value = Double.parseDouble(readValue("Value to transfer"));

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        Transaction transaction = new Transaction("transfer", formatter.parse("24-07-2024"), value, countNumberInsert);
        boolean wasTransfer = repositoryAccount.addTransaction(transaction);
        if (wasTransfer) {
            System.out.println("Successfully transfered");
        } else {
            System.out.println("Insufficient funds");
        }
        boolean wasInserted = userAccount.addTransaction(transaction);
        if (wasInserted) {
            System.out.println("Successfully inserted");
        } else {
            System.out.println("Insufficient funds");
        }
    }

    private static void extract(Account userAccount) throws IOException, ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

        String dateStart = readValue("Insert start date: ");
        String dateEnd = readValue("Insert end date: ");


        List<Transaction> extacts = userAccount.getTransactionByDate(formatter.parse(dateStart), formatter.parse(dateEnd));

        for (int i = 0; i < extacts.size(); i++) {
            System.out.println(extacts.get(i).toString());
        }
    }

    private static void cancelAccount(Account userAccount) throws IOException {
        if (userAccount.getBalance() == 0) {
            userAccount.setActive(false);
            System.out.println("Account canceled successfully");
        } else {
            readValue("It's need reset the account and it is not empty ");
        }
    }


}

