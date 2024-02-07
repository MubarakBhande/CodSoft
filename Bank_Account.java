package codSoft;


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
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void performTransaction(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                deposit(scanner);
                break;
            case 3:
                withdraw(scanner);
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                break;
            default:
                System.out.println("Invalid option. Please select a valid option.");
        }
    }

    private void checkBalance() {
        double balance = bankAccount.getBalance();
        System.out.println("Current Balance: $" + balance);
    }

    private void deposit(Scanner scanner) {
        System.out.print("Enter deposit amount: $");
        double amount = scanner.nextDouble();
        bankAccount.deposit(amount);
    }

    private void withdraw(Scanner scanner) {
        System.out.print("Enter withdrawal amount: $");
        double amount = scanner.nextDouble();
        bankAccount.withdraw(amount);
    }
}

public class Bank_Account {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a BankAccount with an initial balance of $1000
        BankAccount userAccount = new BankAccount(1000);

        // Create an ATM connected to the user's BankAccount
        ATM atm = new ATM(userAccount);

        int choice;
        do {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            atm.performTransaction(choice, scanner);

        } while (choice != 4);

        // Close the scanner
        scanner.close();
    }
	
	

}
