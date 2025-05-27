public class SavingsAccount extends BankAccount {

    private static final double INTEREST_RATE = 0.05; // 5% interest

    public SavingsAccount(
        String name,
        String accNumber,
        double initialBalance
    ) {
        super(name, accNumber, initialBalance);
    }

    public void addInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("Interest added: Rs. " + interest);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited Rs. " + amount + " to Savings Account.");
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Withdrawal failed: Insufficient balance!"
            );
        }
        balance -= amount;
        System.out.println(
            "Withdrawn Rs. " + amount + " from Savings Account."
        );
    }
}
