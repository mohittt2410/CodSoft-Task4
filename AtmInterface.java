import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful......  ");
          //  System.out.println(" New Balance : " + balance);
        } else {
            System.out.println("Invalid amount for deposit.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful......");
         //   System.out.println(" New balance : " + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount for withdrawal.");
        }
    }
}

class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("                                ");
        System.out.println("Welcome To ATM Menu Interface :");
        System.out.println("-------------------------------");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.println("----------------------------------");
       // System.out.println("                                   ");
    }

    public void run() {
        boolean exit = false;

        while (!exit) {
            displayMenu();
            System.out.print(" Enter Your Transaction Choice : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting ATM. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private void checkBalance() {
        System.out.println("Your current balance: " + bankAccount.getBalance());
    }

    private void deposit() {
        System.out.print("Enter Deposit Amount: ");
        double amount = scanner.nextDouble();
        bankAccount.deposit(amount);
    }

    private void withdraw() {
        System.out.print("Enter Withdrawal Amount: ");
        double amount = scanner.nextDouble();
        bankAccount.withdraw(amount);
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance
        System.out.println("------------------------------------------");
        System.out.println(" User Initial Transaction Amount is 1000.0 ");
        System.out.println("----------------------------------------------");
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
