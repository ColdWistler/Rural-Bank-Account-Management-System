package src;

public class CurrentAccount extends BankAccount {

    private double overdraftLimit;

    public CurrentAccount(
        String accountHolderName,
        String accountNumber,
        double initialBalance,
        double overdraftLimit
    ) {
        super(accountHolderName, accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > (getBalance() + overdraftLimit)) {
            throw new InsufficientBalanceException(
                "Insufficient balance (including overdraft)"
            );
        }
        setBalance(getBalance() - amount);
    }

    @Override
    public String displayAccountDetails() {
        return (
            "Current Account Details:\n" +
            "Account Holder: " +
            getAccountHolderName() +
            "\n" +
            "Account Number: " +
            getAccountNumber() +
            "\n" +
            "Balance: " +
            formatCurrency(getBalance()) +
            "\n" +
            "Overdraft Limit: " +
            formatCurrency(overdraftLimit)
        );
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}
