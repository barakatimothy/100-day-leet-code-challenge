import java.util.Scanner;

public class BankSystem {
    // Static variables to store account information
    static String accountHolderName;
    static double accountBalance = 0.0;

    // Method to create a new account
    static void createAccount(String name) {
        accountHolderName = name;
        accountBalance = 0.0; // New account starts with zero balance
        System.out.println("Account created successfully for " + accountHolderName + "!");
    }

    // Method to deposit money
    static void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than 0.");
        } else {
            accountBalance += amount;
            System.out.println("$" + amount + " has been deposited. New balance: $" + accountBalance);
        }
    }

    // Method to withdraw money
    static void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
        } else if (amount > accountBalance) {
            System.out.println("Insufficient funds! Current balance: $" + accountBalance);
        } else {
            accountBalance -= amount;
            System.out.println("$" + amount + " has been withdrawn. Remaining balance: $" + accountBalance);
        }
    }

    // Method to check the balance
    static void checkBalance() {
        System.out.println("Current balance: $" + accountBalance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Banking System!");

        // Step 1: Create an account
        System.out.print("Enter your name to create an account: ");
        String name = scanner.nextLine();
        createAccount(name);

        // Step 2: Provide a menu for operations
        int choice;
        do {
            System.out.println("\n=== Banking Menu ===");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Deposit money
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;

                case 2:
                    // Withdraw money
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;

                case 3:
                    // Check balance
                    checkBalance();
                    break;

                case 4:
                    // Exit
                    System.out.println("Thank you for using the Banking System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
