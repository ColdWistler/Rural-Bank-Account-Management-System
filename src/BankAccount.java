package src;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class BankAccount {

    private String accountHolderName;
    private String accountNumber;
    private double balance;

    public BankAccount(
        String accountHolderName,
        String accountNumber,
        double initialBalance
    ) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public abstract String displayAccountDetails();

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    protected String formatCurrency(double amount) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(
            new Locale("en", "NP")
        );
        return formatter.format(amount);
    }
}
