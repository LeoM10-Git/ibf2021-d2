package ibf2021.d2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private float accountBalance = 0;
    private ArrayList<String> transactions = new ArrayList<>();
    private boolean accountClosed = false;
    private String accountCreatedDate;
    private String accountClosedDate;

    BankAccount(String accountHolderName){
        this.accountHolderName = accountHolderName;
    }
    BankAccount(String accountHolderName, float accountBalance){
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
    }

    public BankAccount() {
    }


    public String getAccountNumber() {
        Random random = new Random();
        this.accountNumber = String.format("%06d", random.nextInt(999999));
        return this.accountNumber;
    }
    public String getAccountHolderName(){
        return this.accountHolderName;
    }

    public float getAccountBalance(){
        return this.accountBalance;
    }

    public boolean getAccountStatus(){
        return this.accountClosed;
    }

    public void getAccountTransactions(){
        if (transactions.size() == 0) System.out.println("You have no transaction history");
        else {
            System.out.println("Here is your transaction history: ");
            for (int i = 0; i < transactions.size(); i++){
                System.out.println(transactions.get(i));
            }
        }
    }

    public void deposit(float deposit){
        LocalDate dateTime = LocalDate.now();
        transactions.add(String.format("Deposit $%s at %s", deposit, dateTime));
        this.accountBalance += deposit;
    }
    public void withdraw(float withdraw){
        LocalDate dateTime = LocalDate.now();
        transactions.add(String.format("Withdraw $%s at %s", withdraw, dateTime));
        this.accountBalance -= withdraw;
    }

    public boolean closeAccount(String request){
        LocalDate closedDate = LocalDate.now();
        this.accountClosedDate = String.valueOf(closedDate);
        if (request.equals("close")) this.accountClosed = true;
        return this.accountClosed;
    }
    public void createAccount(){
        LocalDate createDate = LocalDate.now();
        this.accountCreatedDate = String.valueOf(createDate);
    }
    public String getAccountCreatedDate(){
        return this.accountCreatedDate;
    }

    public String getAccountClosedDate(){
        return this.accountClosedDate;
    }

}
