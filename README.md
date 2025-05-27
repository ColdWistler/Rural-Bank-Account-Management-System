# 🌾 Rural Bank Account Management System (RBAMS)

## 📘 Project Overview

The **Rural Bank Account Management System** is a console-based Java application developed to simulate basic banking operations for the *Rural Bank of Nepal (RBN)*. It aims to offer simple, secure, and efficient financial services like savings and current accounts tailored to remote and rural populations.

---

## 📦 Features

- Support for **multiple account types**: Savings and Current
- **Interest application** on savings accounts
- **Overdraft support** for current accounts
- Secure transactions with **custom exception handling**
- Full implementation of **Object-Oriented Programming (OOP)** principles

---

## 🧱 Class Design

### 🔹 Abstract Class: `BankAccount`
- Common attributes: `accountHolderName`, `accountNumber`, `balance`
- Common methods: `deposit()`, `withdraw()`, `displayDetails()`

### 🔹 Derived Classes
- `SavingsAccount`: 
  - Adds method to apply interest
  - Restricts withdrawals beyond balance
- `CurrentAccount`: 
  - Supports a predefined overdraft limit
  - Allows negative balance up to limit

### 🔹 `Customer` Class
- Aggregates multiple accounts
- Manages operations across all linked accounts

### 🔹 Optional: `Transaction` Interface
- May define standard banking operations for future scalability

---

## 🔐 Exception Handling

- **Custom Exception**: `InsufficientBalanceException`
  - Triggered when withdrawal rules are violated
  - Caught with clear, user-friendly messages in the console

---

## ✅ Supported Operations

- Deposit money into any account
- Withdraw money (with savings/overdraft rules)
- Apply interest to savings accounts
- Handle overdraft logic for current accounts
- Display all accounts of a customer

---

## 🖥 Sample Console Interaction

```text
Welcome to Rural Bank of Nepal
Enter customer name: Sita Devi

Choose operation:
1. Deposit
2. Withdraw
3. Add Interest
4. View Accounts
5. Exit

Select account (1: Savings, 2: Current):
Enter amount: 6000

Withdrawal failed: Insufficient balance!
```

## File Structure
```
RBAMS/
│
├── BankAccount.java
├── SavingsAccount.java
├── CurrentAccount.java
├── Customer.java
├── InsufficientBalanceException.java
├── Main.java
└── README.md
```
