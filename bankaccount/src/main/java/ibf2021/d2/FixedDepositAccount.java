package ibf2021.d2;

import java.util.ArrayList;
import java.util.Random;

public class FixedDepositAccount extends BankAccount{
    private String accountHolderName;
    private String accountNumber;
    private float accountBalance = 0;
    private ArrayList<String> transactions = new ArrayList<>();
    private boolean accountClosed = false;
    private String accountCreatedDate;
    private String accountClosedDate;
    private float interest = 3;
    private int durations = 6;

    public FixedDepositAccount(String name, Float balance){
        super();
        this.accountHolderName = name;
        this.accountBalance = balance;
    }


//    public FixedDepositAccount(String name, Float balance,Float interest){
//
//    }
//    public FixedDepositAccount(String name, Float balance, Float interest, Float duration){
//
//    }
        public String getAccountHolderName() {
            return this.accountHolderName;
        }
        public String getAccountNumber() {
            Random random = new Random();
            this.accountNumber = String.format("%06d", random.nextInt(999999));
            return this.accountNumber;
        }

        @Override
        public float getAccountBalance(){
            return this.accountBalance * (1+interest/100);
        }
}
