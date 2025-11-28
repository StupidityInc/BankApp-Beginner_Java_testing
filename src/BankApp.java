import java.math.BigDecimal;

public class BankApp {
    public static void main(String[] args) {
        try {
            Bank tauBank = new Bank();
            SavingsAccount saving = new SavingsAccount("67", "Uri", new BigDecimal("1000000000.00"));
            tauBank.addAccount(saving);
            CheckingAccount checking = new CheckingAccount("69", "Jony", new BigDecimal("99999999999999.00"));
            tauBank.addAccount(checking);
            tauBank.applyMonthlyFees();
        } catch (InsufficientFundsException e) {
            System.err.println("--- FATAL BANKING ERROR ---");
            System.err.println("Transaction Halted: " + e.getMessage());
        }
    }
}
