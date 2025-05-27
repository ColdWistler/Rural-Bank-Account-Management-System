#   Rural Bank Account Management System (RBAMS) - JavaFX GUI Application

    This README provides an overview of the JavaFX GUI version of the Rural Bank Account Management System (RBAMS). While the original assignment specified a console-based application, this implementation utilizes a graphical user interface (GUI) to enhance user interaction and experience. The application allows users to manage customer bank accounts, including Savings and Current accounts. [cite: 24, 25, 26, 27, 31, 32, 33, 34, 35, 36, 37, 38, 39]

    ##   Project Description

    The Rural Bank of Nepal (RBN) aims to provide basic banking services in remote areas of Nepal. [cite: 22, 23] This system is designed to be simple, secure, and efficient. [cite: 2, 3] This JavaFX application offers a user-friendly interface for bank staff to manage customer accounts, performing operations such as creating accounts, depositing and withdrawing funds, applying interest, and viewing account details. [cite: 10, 11, 12, 13, 14, 15, 16, 17, 18, 39]

    ##   Features

    The RBAMS JavaFX GUI application supports the following features:

    * **Customer Management:**
        * Allows users to create a new customer by entering their name or select an existing customer. [cite: 10, 14]
    * **Account Creation:**
        * Users can create new Savings or Current accounts for the currently selected customer. [cite: 10, 11]
        * For Savings accounts, users can specify the initial balance and annual interest rate. [cite: 11]
        * For Current accounts, users can specify the initial balance and overdraft limit. [cite: 11]
    * **Account Selection:**
        * A dropdown menu (ComboBox) displays all accounts associated with the current customer.
        * Users can select an account to perform operations.
    * **Account Details Display:**
        * The details of the selected account (account holder name, account number, balance, interest rate for savings, overdraft limit for current) are displayed. [cite: 39]
    * **Deposit:**
        * Users can deposit a specified amount into the selected account using a dialog box for input. [cite: 39]
        * The application validates that the deposit amount is positive.
    * **Withdraw:**
        * Users can withdraw a specified amount from the selected account using a dialog box. [cite: 39]
        * For Savings accounts, withdrawal is not allowed if it exceeds the current balance. [cite: 7, 28]
        * For Current accounts, withdrawal is allowed up to the balance plus the overdraft limit. [cite: 7, 28, 32]
        * The application handles insufficient balance scenarios with informative alerts. [cite: 15, 16, 17, 36, 37, 38]
    * **Add Interest (Savings Account):**
        * A button allows users to add interest to the selected Savings account. This button is disabled if a Current account is selected. [cite: 11, 29]
    * **User-Friendly Interface:**
        * Provides a graphical interface using JavaFX controls.
        * Uses Alert dialogs to display information and error messages.

    ##   Class Design and OOP Concepts

    The application is designed using the following Object-Oriented Programming (OOP) concepts, as emphasized in the assignment: [cite: 9, 10, 11, 12, 13, 14, 31, 32, 33, 34, 35]

    * **Abstraction:** The `BankAccount` class is an abstract class, defining the common interface for all account types. [cite: 10, 12, 31, 33]
    * **Inheritance:** The `SavingsAccount` and `CurrentAccount` classes inherit from the `BankAccount` class. [cite: 11, 13, 32, 34]
    * **Encapsulation:** Data members (attributes) are kept private, and access is controlled through getter/setter methods. [cite: 13, 34]
    * **Polymorphism:** Polymorphism is used in methods like `displayAccountDetails()` to provide account-type-specific output. [cite: 14, 35]
    * **Aggregation:** The `Customer` class maintains a list of `BankAccount` objects. [cite: 14, 35]

    ##   Custom Exception Handling

    * A custom exception class `InsufficientBalanceException` is defined. [cite: 15, 36]
    * This exception is thrown when a withdrawal amount exceeds the allowed limit. [cite: 16, 37]
    * The exception is caught and handled in the application, and a user-friendly message is displayed using JavaFX Alert dialogs. [cite: 17, 38]

    ##   How to Run

    1.  Ensure you have the Java Development Kit (JDK) and JavaFX SDK installed and configured.
    2.  Compile the Java source code files. You will need to include the JavaFX modules in the compilation command.
        ```bash
        javac --module-path /path/to/javafx-sdk-xx/lib --add-modules javafx.controls,javafx.graphics src/*.java -d out
        ```
        (Replace `/path/to/javafx-sdk-xx/lib` with the actual path to your JavaFX SDK.)
    3.  Run the application. You will also need to include the JavaFX modules when running the application.
        ```bash
        java --module-path /path/to/javafx-sdk-xx/lib --add-modules javafx.controls,javafx.graphics src.Main # or src.MainApplication
        ```

    ##   Screenshots

    (Drag and drop your screenshots here, or provide file paths)

    **Screenshot 1: Deposit Operation**

    <br><br><br><br><br><br><br><br><br><br>

    **Screenshot 2: Withdrawal Attempt with InsufficientBalanceException**

    <br><br><br><br><br><br><br><br><br><br>

    **Screenshot 3: Adding Interest to a Savings Account**

    <br><br><br><br><br><br><br><br><br><br>

    This README adapts the assignment requirements to the context of a JavaFX GUI application, explaining how the GUI fulfills the objectives while adhering to OOP principles and exception handling.
