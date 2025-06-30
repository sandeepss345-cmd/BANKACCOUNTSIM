import java.util.ArrayList;
import java.util.Scanner;

// Bank Account class (not public)
class Account {
    private String accountHolder;
    private String accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: Rs. " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        transactionHistory.add("Deposited: Rs. " + amount);
        System.out.println("Rs. " + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            transactionHistory.add("Withdrew: Rs. " + amount);
            System.out.println("Rs. " + amount + " withdrawn successfully.");
        }
    }

    public void showBalance() {
        System.out.println("Current balance: Rs. " + balance);
    }

    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println("- " + transaction);
        }
    }
}

// ✅ Class name matches filename exactly: Bankaccount.java
public class Bankaccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Welcome to Java Bank Simulation ===");
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter account number: ");
        String accNum = sc.nextLine();

        System.out.print("Enter initial deposit amount: Rs. ");
        double initial = sc.nextDouble();

        Account myAccount = new Account(name, accNum, initial);

        int choice;
        do {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Show Transaction History");
            System.out.println("5. Exit");

            System.out.print("Your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: Rs. ");
                    double dep = sc.nextDouble();
                    myAccount.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: Rs. ");
                    double wd = sc.nextDouble();
                    myAccount.withdraw(wd);
                    break;

                case 3:
                    myAccount.showBalance();
                    break;

                case 4:
                    myAccount.showTransactionHistory();
                    break;

                case 5:
                    System.out.println("Thank you for using Java Bank!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
