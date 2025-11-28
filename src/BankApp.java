// In BankApp.java

import java.math.BigDecimal;

public class BankApp {

    private static final String FILE_NAME = "tau_bank.dat"; // Define a file name

    public static void main(String[] args) {
        try {
            // 1. ATTEMPT TO LOAD THE BANK
            Bank tauBank = Bank.loadBank(FILE_NAME);

            if (tauBank.findAccount("69") == null) {
                // 2. IF starting a new bank, create and save the initial accounts
                System.out.println("Creating initial accounts...");
                SavingsAccount saving = new SavingsAccount("67", "Uri", new BigDecimal("1000.00"));
                CheckingAccount checking = new CheckingAccount("69", "Jony", new BigDecimal("70.00"));

                tauBank.addAccount(saving);
                tauBank.addAccount(checking);

                // Perform a transaction before saving
                checking.applyMonthlyFee();
                System.out.println("Jony's balance after fee: " + checking.getBalance());

                // SAVE the bank
                tauBank.saveBank(FILE_NAME);
            } else {
                // 3. IF LOADED, verify the balance
                System.out.println("--- Verification of Loaded Data ---");
                BankAccount jony = tauBank.findAccount("69");
                System.out.println("Found Jony's account (ID 69).");
                System.out.println("Balance must be 20.00 (70.00 - 50.00 fee).");
                System.out.println("Loaded Balance: " + jony.getBalance());
            }

        } catch (Exception e) { // Catch all IO/Class/InsufficientFunds exceptions
            System.err.println("--- CRITICAL SYSTEM ERROR ---");
            e.printStackTrace(); // Print the full stack trace for debugging
        }
    }
}