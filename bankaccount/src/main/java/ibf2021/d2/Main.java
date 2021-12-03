package ibf2021.d2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Hi, here is your new account, please input your account name: ");
            String inputName = scanner.nextLine();
            System.out.print("What's your balance to deposit:");
            float depositBalance = scanner.nextFloat();
            scanner.nextLine();
            BankAccount account1 = new BankAccount(inputName, depositBalance);
            System.out.println("Hi " + account1.getAccountHolderName());
            account1.createAccount();
            System.out.println("This is your account number: " + account1.getAccountNumber());
            System.out.println("Your current account balance: $" + account1.getAccountBalance());

            while(!account1.getAccountStatus()){
                //selection input
                System.out.print("Please choose operation for your account, deposit/withdraw/close: ");
                String selection = scanner.nextLine().toLowerCase();
                switch (selection){
                    //select deposit
                    case "deposit":
                        System.out.print("How much you want to deposit: $");
                        float inputDeposit = scanner.nextFloat();
                        //check the amount is positive, or throw exception
                        if (inputDeposit <=0 ){
                            throw new IllegalArgumentException("Only positive amount accept.");
                        }
                        account1.deposit(inputDeposit);
                        scanner.nextLine();
                        break;

                    //select withdraw
                    case "withdraw":
                        System.out.print("How much you want to withdraw: $");
                        float inputWithdraw = scanner.nextFloat();
                        scanner.nextLine();
                        //check the amount is positive
                        if (inputWithdraw <=0 ){
                            throw new IllegalArgumentException("Only positive amount accept.");
                        }
                        account1.withdraw(inputWithdraw);
                        break;

                    //select close
                    case "close":
                        System.out.println("Your account is closed");
                        account1.closeAccount("close");
                        break;
                }

            }
            System.out.printf("Your account is created on %s, and closed on %s.\n",account1.getAccountCreatedDate(),
                    account1.getAccountClosedDate());
            System.out.println("Your account balance is "+ account1.getAccountBalance());
            account1.getAccountTransactions();

            //create fixed deposit account
            System.out.print("\n\nHi, here is your new fixed deposit account, please input your account name: ");
            String fixedDepositAccountName = scanner.nextLine();
            System.out.print("What's your balance to deposit:");
            float initialBalance = scanner.nextFloat();
            scanner.nextLine();
            BankAccount account2 = new FixedDepositAccount(fixedDepositAccountName, initialBalance);
            account2.createAccount();
            System.out.println("Hi " + account2.getAccountHolderName());
            System.out.println("This is your account number: " + account2.getAccountNumber());
            System.out.println("Your account balance after durations: $" + account2.getAccountBalance());
        }

    }
}