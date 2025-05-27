public class CurrentAccount extends BankAccount {

    private static final double OVERDRAFT_LIMIT = 5000;

    public CurrentAccount(
        String name,
        String accNumber,
        double initialBalance
    ) {
        super(name, accNumber, initialBalance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited Rs. " + amount + " to Current Account.");
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > (balance + OVERDRAFT_LIMIT)) {
            throw new InsufficientBalanceException(
                "Withdrawal failed: Overdraft limit exceeded!"
            );
        }
        balance -= amount;
        System.out.println(
            "Withdrawn Rs. " + amount + " from Current Account."
        );
    }
}
