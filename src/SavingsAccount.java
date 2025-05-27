package src;

public class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(
        String accountHolderName,
        String accountNumber,
        double initialBalance,
        double interestRate
    ) {
        super(accountHolderName, accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > getBalance()) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        setBalance(getBalance() - amount);
    }

    public void addInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
    }

    @Override
    public String displayAccountDetails() {
        return (
            "Savings Account Details:\n" +
            "Account Holder: " +
            getAccountHolderName() +
            "\n" +
            "Account Number: " +
            getAccountNumber() +
            "\n" +
            "Balance: " +
            formatCurrency(getBalance()) +
            "\n" +
            "Interest Rate: " +
            String.format("%.2f%%", interestRate * 100)
        );
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
