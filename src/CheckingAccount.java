import java.math.BigDecimal;

public class CheckingAccount extends BankAccount{
    private static final BigDecimal MONTHLY_FEE = new BigDecimal("50.00");

    public CheckingAccount(String id, String owner, BigDecimal initialDeposit){
        super(id, owner, initialDeposit);

    }
    public boolean applyMonthlyFee(){
        if (this.getBalance().compareTo(MONTHLY_FEE) >= 0) {
            return this.withdraw(MONTHLY_FEE);
        }
        return false;
    }
}
