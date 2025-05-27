public abstract class BankAccount {

    protected String accountHolderName;
    protected String accountNumber;
    protected double balance;

    public BankAccount(String name, String accNumber, double initialBalance) {
        this.accountHolderName = name;
        this.accountNumber = accNumber;
        this.balance = initialBalance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount)
        throws InsufficientBalanceException;

    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: Rs. " + balance);
    }

    public String getAccountType() {
        return this instanceof SavingsAccount ? "Savings" : "Current";
    }
}
