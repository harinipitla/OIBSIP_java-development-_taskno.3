import java.util.Scanner;

public class ATMOperations {

    public static void withdraw(User user, TransactionHistory history, Scanner sc) {
        System.out.print("Enter amount to withdraw: ");
        double amount = Double.parseDouble(sc.nextLine());
        if (amount <= 0) System.out.println("Amount must be positive.");
        else if (amount > user.getBalance()) System.out.println("Insufficient balance.");
        else {
            user.setBalance(user.getBalance() - amount);
            history.addTransaction(new Transaction("Withdraw", amount, "Balance: $" + user.getBalance()));
            System.out.println("✔ Withdraw successful. Current Balance: $" + user.getBalance());
        }
    }

    public static void deposit(User user, TransactionHistory history, Scanner sc) {
        System.out.print("Enter amount to deposit: ");
        double amount = Double.parseDouble(sc.nextLine());
        if (amount <= 0) System.out.println("Amount must be positive.");
        else {
            user.setBalance(user.getBalance() + amount);
            history.addTransaction(new Transaction("Deposit", amount, "Balance: $" + user.getBalance()));
            System.out.println("✔ Deposit successful. Current Balance: $" + user.getBalance());
        }
    }

    public static void transfer(User user, TransactionHistory history, Scanner sc) {
        System.out.print("Enter recipient ID: ");
        String recipient = sc.nextLine();
        System.out.print("Enter amount to transfer: ");
        double amount = Double.parseDouble(sc.nextLine());
        if (amount <= 0) System.out.println("Amount must be positive.");
        else if (amount > user.getBalance()) System.out.println("Insufficient balance.");
        else {
            user.setBalance(user.getBalance() - amount);
            history.addTransaction(new Transaction("Transfer", amount, "To: " + recipient + " | Balance: $" + user.getBalance()));
            System.out.println("✔ Transfer successful. Current Balance: $" + user.getBalance());
        }
    }
}
