package src;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String customerName;
    private List<BankAccount> accounts;

    public Customer(String customerName) {
        this.customerName = customerName;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public String getCustomerName() {
        return customerName;
    }
}
