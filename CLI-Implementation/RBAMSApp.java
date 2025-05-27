import java.util.Scanner;

public class RBAMSApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Rural Bank of Nepal");

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        Customer customer = new Customer(name);

        // Creating accounts for demo
        BankAccount savings = new SavingsAccount(name, "SA1001", 10000);
        BankAccount current = new CurrentAccount(name, "CA1001", 5000);
        customer.addAccount(savings);
        customer.addAccount(current);

        int choice;
        do {
            System.out.println("\nChoose operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Add Interest");
            System.out.println("4. View Accounts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            BankAccount selectedAccount = null;

            if (choice >= 1 && choice <= 3) {
                System.out.print("Select account (1: Savings, 2: Current): ");
                int accType = scanner.nextInt();
                selectedAccount = (accType == 1) ? savings : current;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dep = scanner.nextDouble();
                    selectedAccount.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double wd = scanner.nextDouble();
                    try {
                        selectedAccount.withdraw(wd);
                    } catch (InsufficientBalanceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    if (selectedAccount instanceof SavingsAccount) {
                        ((SavingsAccount) selectedAccount).addInterest();
                    } else {
                        System.out.println(
                            "Interest can only be added to Savings Account."
                        );
                    }
                    break;
                case 4:
                    for (BankAccount acc : customer.getAccounts()) {
                        System.out.println(
                            "\n--- " + acc.getAccountType() + " Account ---"
                        );
                        acc.displayAccountDetails();
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using RBAMS.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }
}
