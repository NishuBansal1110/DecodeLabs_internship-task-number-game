import java.util.Scanner;

// BankAccount class
class BankAccount {
    private double balance;

    // constructor
    public BankAccount(double initialBalance) {
        if (initialBalance > 0) {
            balance = initialBalance;
        } else {
            balance = 0;
        }
    }

    // check balance
    public double checkBalance() {
        return balance;
    }

    // deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Amount Deposited Successfully!");
        } else {
            System.out.println("❌ Invalid amount! Enter amount > 0");
        }
    }

    // withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid amount!");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println("✅ Withdrawal Successful!");
        }
    }
}

// ATM class
class ATM {
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        sc = new Scanner(System.in);
    }

    // safe double input
    private double getValidAmount() {
        while (!sc.hasNextDouble()) {
            System.out.println("❌ Invalid input! Enter a number:");
            sc.next(); // clear buffer
        }
        return sc.nextDouble();
    }

    // menu system
    public void start() {
        int choice;

        while (true) {
            System.out.println("\n====== ATM MENU ======");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("❌ Invalid choice! Enter number:");
                sc.next();
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("💰 Balance: " + account.checkBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = getValidAmount();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = getValidAmount();
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("👋 Thank you for using ATM!");
                    return;

                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}

// Main class
public class DecodeLabs_Java_p3 {
    public static void main(String[] args) {

        BankAccount userAccount = new BankAccount(1000); // initial balance
        ATM atm = new ATM(userAccount);

        atm.start();
    }
}