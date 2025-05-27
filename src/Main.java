package src;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application { 

    private Map<String, Customer> customers = new HashMap<>();
    private int accountNumberCounter = 1000;
    private Customer currentCustomer;
    private ComboBox<BankAccount> accountComboBox = new ComboBox<>();
    private Label accountDetailsLabel = new Label("No account selected.");
    private Button addInterestButton; 

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Rural Bank of Nepal");

        // Customer Creation Section
        Label customerLabel = new Label("Customer Name:");
        TextField customerNameField = new TextField();
        Button createCustomerButton = new Button("Create/Select Customer");
        createCustomerButton.setOnAction(e -> {
            String name = customerNameField.getText().trim();
            if (!name.isEmpty()) {
                currentCustomer = customers.computeIfAbsent(
                    name,
                    Customer::new
                );
                populateAccountComboBox();
                updateAccountDetails();
                showAlert(
                    "Customer '" +
                    currentCustomer.getCustomerName() +
                    "' selected."
                );
            } else {
                showAlert("Please enter a customer name.");
            }
        });
        HBox customerBox = new HBox(
            10,
            customerLabel,
            customerNameField,
            createCustomerButton
        );

        // Account Selection
        Label selectAccountLabel = new Label("Select Account:");
        accountComboBox.setOnAction(e -> updateAccountDetails());
        HBox accountSelectionBox = new HBox(
            10,
            selectAccountLabel,
            accountComboBox
        );

        // Account Details Display
        VBox accountDetailsBox = new VBox(
            10,
            new Label("Account Details:"),
            accountDetailsLabel
        );

        // Operations Buttons
        Button depositButton = new Button("Deposit");
        depositButton.setOnAction(e -> performDeposit());

        Button withdrawButton = new Button("Withdraw");
        withdrawButton.setOnAction(e -> performWithdraw());

        addInterestButton = new Button("Add Interest"); // Initialize addInterestButton
        addInterestButton.setOnAction(e -> performAddInterest());
        addInterestButton.setDisable(true); // Initially disabled

        Button createAccountButton = new Button("Create New Account");
        createAccountButton.setOnAction(e -> showCreateAccountDialog());

        HBox operationsBox = new HBox(
            10,
            depositButton,
            withdrawButton,
            addInterestButton,
            createAccountButton
        );

        // Main Layout
        VBox mainLayout = new VBox(
            20,
            customerBox,
            accountSelectionBox,
            accountDetailsBox,
            operationsBox
        );
        mainLayout.setPadding(new Insets(20));

        Scene scene = new Scene(mainLayout, 400, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void populateAccountComboBox() {
        if (currentCustomer != null) {
            accountComboBox.setItems(
                FXCollections.observableList(currentCustomer.getAccounts())
            );
        } else {
            accountComboBox.setItems(FXCollections.emptyObservableList());
        }
        // Enable/disable Add Interest button based on selected account type
        accountComboBox
            .getSelectionModel()
            .selectedItemProperty()
            .addListener((obs, oldVal, newVal) -> {
                addInterestButton.setDisable(
                    !(newVal instanceof SavingsAccount)
                );
            });
    }

    private void updateAccountDetails() {
        BankAccount selectedAccount = accountComboBox.getValue();
        if (selectedAccount != null) {
            accountDetailsLabel.setText(
                selectedAccount.displayAccountDetails()
            );
        } else {
            accountDetailsLabel.setText("No account selected.");
        }
    }

    private void performDeposit() {
        BankAccount account = accountComboBox.getValue();
        if (account == null) {
            showAlert("Please select an account.");
            return;
        }

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Deposit");
        dialog.setHeaderText("Enter amount to deposit:");
        Optional<String> result = dialog.showAndWait();

        result.ifPresent(amountStr -> {
            try {
                double amount = Double.parseDouble(amountStr);
                if (amount > 0) {
                    account.deposit(amount);
                    updateAccountDetails();
                    showAlert("Deposit successful.");
                } else {
                    showAlert("Please enter a positive amount.");
                }
            } catch (NumberFormatException e) {
                showAlert("Invalid amount entered.");
            }
        });
    }

    private void performWithdraw() {
        BankAccount account = accountComboBox.getValue();
        if (account == null) {
            showAlert("Please select an account.");
            return;
        }

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Withdraw");
        dialog.setHeaderText("Enter amount to withdraw:");
        Optional<String> result = dialog.showAndWait();

        result.ifPresent(amountStr -> {
            try {
                double amount = Double.parseDouble(amountStr);
                if (amount > 0) {
                    try {
                        account.withdraw(amount);
                        updateAccountDetails();
                        showAlert("Withdrawal successful.");
                    } catch (InsufficientBalanceException e) {
                        showAlert("Withdrawal failed: " + e.getMessage());
                    }
                } else {
                    showAlert("Please enter a positive amount.");
                }
            } catch (NumberFormatException e) {
                showAlert("Invalid amount entered.");
            }
        });
    }

    private void performAddInterest() {
        BankAccount account = accountComboBox.getValue();
        if (account instanceof SavingsAccount) {
            ((SavingsAccount) account).addInterest();
            updateAccountDetails();
            showAlert("Interest added.");
        } else {
            showAlert("Interest can only be added to a savings account.");
        }
    }

    private void showCreateAccountDialog() {
        if (currentCustomer == null) {
            showAlert("Please create or select a customer first.");
            return;
        }

        ChoiceDialog<String> accountTypeDialog = new ChoiceDialog<>(
            "Savings",
            "Savings",
            "Current"
        );
        accountTypeDialog.setTitle("Create New Account");
        accountTypeDialog.setHeaderText(
            "Select the type of account to create:"
        );
        Optional<String> accountTypeResult = accountTypeDialog.showAndWait();

        accountTypeResult.ifPresent(type -> {
            TextInputDialog balanceDialog = new TextInputDialog();
            balanceDialog.setTitle("Create New Account");
            balanceDialog.setHeaderText("Enter initial balance:");
            Optional<String> balanceResult = balanceDialog.showAndWait();

            balanceResult.ifPresent(balanceStr -> {
                try {
                    double initialBalance = Double.parseDouble(balanceStr);
                    if (initialBalance >= 0) {
                        if (type.equals("Savings")) {
                            TextInputDialog interestDialog =
                                new TextInputDialog();
                            interestDialog.setTitle("Create Savings Account");
                            interestDialog.setHeaderText(
                                "Enter annual interest rate (e.g., 0.05 for 5%):"
                            );
                            Optional<String> interestResult =
                                interestDialog.showAndWait();
                            interestResult.ifPresent(interestStr -> {
                                try {
                                    double interestRate = Double.parseDouble(
                                        interestStr
                                    );
                                    if (interestRate >= 0) {
                                        SavingsAccount newAccount =
                                            new SavingsAccount(
                                                currentCustomer.getCustomerName(),
                                                generateAccountNumber(),
                                                initialBalance,
                                                interestRate
                                            );
                                        currentCustomer.addAccount(newAccount);
                                        populateAccountComboBox();
                                        showAlert(
                                            "Savings account created successfully."
                                        );
                                    } else {
                                        showAlert(
                                            "Interest rate must be non-negative."
                                        );
                                    }
                                } catch (NumberFormatException e) {
                                    showAlert("Invalid interest rate.");
                                }
                            });
                        } else if (type.equals("Current")) {
                            TextInputDialog overdraftDialog =
                                new TextInputDialog();
                            overdraftDialog.setTitle("Create Current Account");
                            overdraftDialog.setHeaderText(
                                "Enter overdraft limit:"
                            );
                            Optional<String> overdraftResult =
                                overdraftDialog.showAndWait();
                            overdraftResult.ifPresent(overdraftStr -> {
                                try {
                                    double overdraftLimit = Double.parseDouble(
                                        overdraftStr
                                    );
                                    if (overdraftLimit >= 0) {
                                        CurrentAccount newAccount =
                                            new CurrentAccount(
                                                currentCustomer.getCustomerName(),
                                                generateAccountNumber(),
                                                initialBalance,
                                                overdraftLimit
                                            );
                                        currentCustomer.addAccount(newAccount);
                                        populateAccountComboBox();
                                        showAlert(
                                            "Current account created successfully."
                                        );
                                    } else {
                                        showAlert(
                                            "Overdraft limit must be non-negative."
                                        );
                                    }
                                } catch (NumberFormatException e) {
                                    showAlert("Invalid overdraft limit.");
                                }
                            });
                        }
                    } else {
                        showAlert("Initial balance must be non-negative.");
                    }
                } catch (NumberFormatException e) {
                    showAlert("Invalid initial balance.");
                }
            });
        });
    }

    private String generateAccountNumber() {
        return "ACC-" + accountNumberCounter++;
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
