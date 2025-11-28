import java.math.BigDecimal;

public class BankAccount {
    private final String id;
    private String owner;
    private BigDecimal balance;

    public BankAccount(String id, String owner, BigDecimal initialDeposit) {
        this.id = id;
        this.owner = owner;
        this.balance = initialDeposit;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void deposit(BigDecimal amount) {
        this.balance = balance.add(amount);
    }
    public void withdraw(BigDecimal amount) throws InsufficientFundsException {
        if (balance.compareTo(amount) >= 0) {
            this.balance = this.balance.subtract(amount);
            return;
        }
        throw new InsufficientFundsException("Withdrawal failed: Account ID " + this.getId() + " has insufficient funds.");
    }

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}

