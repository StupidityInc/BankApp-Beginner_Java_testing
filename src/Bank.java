
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bank implements Serializable {
    private List<BankAccount> bankAccounts = new ArrayList<BankAccount>();

    public void addAccount(BankAccount account) {
        bankAccounts.add(account);
    }

    public BankAccount findAccount(String id) {
        for (BankAccount account : bankAccounts) {
            if (account.getId().equals(id)) {
                return account;
            }
        }
        return null;
    }

    public void applyMonthlyFees() throws InsufficientFundsException {
        for (BankAccount account : bankAccounts) {
            if (account instanceof CheckingAccount) {
                CheckingAccount checking = (CheckingAccount) account;
                checking.applyMonthlyFee();
            }
        }
    }

    public void saveBank(String filename) throws IOException {
        try (
                // 1. Open the low-level connection to the file
                FileOutputStream fileOut = new FileOutputStream(filename);

                // 2. Open the object-writing stream, piping data to the file connection
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)
        ) {
            // 3. Write the entire 'Bank' object (this) to the stream
            objectOut.writeObject(this);}
    }

    public static Bank loadBank(String filename) throws IOException, ClassNotFoundException {
        try (
                // 1. Open the low-level connection to the file
                FileInputStream fileIn = new FileInputStream(filename);

                // 2. Open the object-reading stream, piping data from the file
                ObjectInputStream objectIn = new ObjectInputStream(fileIn)
        ) {
            // 3. Read the object from the stream and cast it back to the Bank type
            Bank loadedBank = (Bank) objectIn.readObject();

            System.out.println("Bank data successfully loaded from " + filename);
            return loadedBank;

        } catch (java.io.FileNotFoundException e) {
            // If the file doesn't exist yet, return a brand new bank
            System.out.println("No saved bank data found. Starting a new bank.");
            return new Bank();
        }
    }
}
