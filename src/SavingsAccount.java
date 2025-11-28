import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {
    protected static final BigDecimal MINIMUM_BALANCE = new BigDecimal("500.00");

    public SavingsAccount(String id, String owner, BigDecimal initialDeposit) {
        super(id, owner, initialDeposit);
    }

    @Override
    public boolean withdraw(BigDecimal amount) {
        if (this.getBalance().compareTo(amount.add(MINIMUM_BALANCE)) >= 0) {
            return super.withdraw(amount);
        }
        return false;
    }
}
