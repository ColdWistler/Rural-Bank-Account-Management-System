#   🏦 Rural Bank Account Management System (RBAMS) - JavaFX GUI Application 🧑‍💻

 This README provides an overview of the JavaFX GUI version of the Rural Bank Account Management System (RBAMS). While the original assignment specified a console-based application, this implementation utilizes a graphical user interface (GUI) to enhance user interaction and experience. The application allows users to manage customer bank accounts, including Savings 💰 and Current 💳 accounts.

 ##   📜 Project Description

The Rural Bank of Nepal (RBN) aims to provide basic banking services in remote areas of Nepal. This system is designed to be simple, secure, and efficient. This JavaFX application offers a user-friendly interface for bank staff to manage customer accounts, performing operations such as creating accounts, depositing 💸 and withdrawing funds, applying interest 📈, and viewing account details.

##   ✨ Features

The RBAMS JavaFX GUI application supports the following features:

* **🧑‍🤝‍🧑 Customer Management:**

  * Allows users to create a new customer by entering their name or select an existing customer.
* **🏦 Account Creation:**

   * Users can create new Savings or Current accounts for the currently selected customer.
  * For Savings accounts, users can specify the initial balance and annual interest rate.
        * For Current accounts, users can specify the initial balance and overdraft limit.
* **🗂️ Account Selection:**

   * A dropdown menu (ComboBox) displays all accounts associated with the current customer.
        * Users can select an account to perform operations.
* **ℹ️ Account Details Display:**

  * The details of the selected account (account holder name, account number, balance, interest rate for savings, overdraft limit for current) are displayed.
* **💸 Deposit:**

  * Users can deposit a specified amount into the selected account using a dialog box for input.
        * The application validates that the deposit amount is positive.
* **💳 Withdraw:**

  * Users can withdraw a specified amount from the selected account using a dialog box.
        * For Savings accounts, withdrawal is not allowed if it exceeds the current balance.
        * For Current accounts, withdrawal is allowed up to the balance plus the overdraft limit.
        * The application handles insufficient balance scenarios with informative alerts 🚨.
* **📈 Add Interest (Savings Account):**

   * A button allows users to add interest to the selected Savings account. This button is disabled if a Current account is selected.
 * **🖥️ User-Friendly Interface:**

   * Provides a graphical interface using JavaFX controls.
        * Uses Alert dialogs to display information and error messages.

##   👨‍💻 Class Design and OOP Concepts

   The application is designed using the following Object-Oriented Programming (OOP) concepts, as emphasized in the assignment:

   * **Abstraction 🌳:** The `BankAccount` class is an abstract class, defining the common interface for all account types.
   * **Inheritance 🧬:** The `SavingsAccount` and `CurrentAccount` classes inherit from the `BankAccount` class.
   * **Encapsulation 🔒:** Data members (attributes) are kept private, and access is controlled through getter/setter methods.
   * **Polymorphism 🎭:** Polymorphism is used in methods like `displayAccountDetails()` to provide account-type-specific output.
   * **Aggregation 🤝:** The `Customer` class maintains a list of `BankAccount` objects.

##   ⚠️ Custom Exception Handling

   * A custom exception class `InsufficientBalanceException` is defined.
    * This exception is thrown when a withdrawal amount exceeds the allowed limit.
    * The exception is caught and handled in the application, and a user-friendly message is displayed using JavaFX Alert dialogs.

 ##   🚀 How to Run

   1.  Ensure you have the Java Development Kit (JDK) ☕ and JavaFX SDK 🧩 installed and configured.
    2.  Compile the Java source code files. You will need to include the JavaFX modules in the compilation command.

        ```bash
        javac --module-path /path/to/javafx-sdk-xx/lib --add-modules javafx.controls,javafx.graphics src/*.java -d out
        ```

        (Replace `/path/to/javafx-sdk-xx/lib` with the actual path to your JavaFX SDK.)
    3.  Run the application. You will also need to include the JavaFX modules when running the application.

        ```bash
        java --module-path /path/to/javafx-sdk-xx/lib --add-modules javafx.controls,javafx.graphics src.Main # or src.MainApplication
        ```

##   📸 Screenshots


   **Screenshot 1: Deposit Operation 💸**

   <br>![Deposit](https://github.com/user-attachments/assets/1e43f1e2-feea-4e03-82fb-14ea8571403d)
<br><br><br><br>
![DepositSuccess](https://github.com/user-attachments/assets/9afe2633-c0a3-4db0-91b2-501f733c7095)
<br><br>

   **Screenshot 2: Withdrawal Attempt with InsufficientBalanceException 💳 🚨**

   <br><br>![Withdrawlexception](https://github.com/user-attachments/assets/fb9bb93b-3454-4e62-bce7-003809c5fb93)
<br><br>![withdrawlsuccess](https://github.com/user-attachments/assets/0dfa530f-fa86-4910-86fd-a2f944ff2c03)
<br><br><br>

   **Screenshot 3: Adding Interest to a Savings Account 📈 💰**

   <br><br><br><br>![Interest](https://github.com/user-attachments/assets/304d1860-d769-4ea9-9db1-0c2dbfdd97ea)
<br><br><br><br><br><br>

 
