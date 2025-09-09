import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        User user = new User("user123", "1234", 5000);
        TransactionHistory history = new TransactionHistory();

        System.out.println("=== Welcome to ATM Interface ===");
        System.out.print("Enter User ID: ");
        String id = sc.nextLine();
        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        if (!id.equals(user.getUserId()) || !pin.equals(user.getPin())) {
            System.out.println("❌ Invalid ID or PIN. Exiting...");
            sc.close();
            return;
        }

        System.out.println("✔ Login successful!");

        boolean running = true;
        while (running) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option (1-5): ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    history.showHistory();
                    break;
                case "2":
                    ATMOperations.withdraw(user, history, sc);
                    break;
                case "3":
                    ATMOperations.deposit(user, history, sc);
                    break;
                case "4":
                    ATMOperations.transfer(user, history, sc);
                    break;
                case "5":
                    System.out.println("Thank you for using ATM. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        sc.close();
    }
}
