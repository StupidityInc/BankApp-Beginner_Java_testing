
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> bankAccounts = new ArrayList<BankAccount>();

    public void addAccount(BankAccount account){
        bankAccounts.add(account);
    }
    public BankAccount findAccount(String id){
        for (BankAccount account : bankAccounts){
            if (account.getId().equals(id)){
                return account;
            }
        }
        return null;
    }
    public void applyMonthlyFees() throws InsufficientFundsException{
        for (BankAccount account : bankAccounts){
            if (account instanceof CheckingAccount){
                CheckingAccount checking = (CheckingAccount) account;
                checking.applyMonthlyFee();
            }
        }
    }
}
