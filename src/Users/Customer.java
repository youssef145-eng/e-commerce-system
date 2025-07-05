package Users;

import java.math.BigDecimal;

public class Customer {
    private String name;
    private BigDecimal balance;

    public Customer(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
    }

    public boolean canPay(BigDecimal amount) {
        return balance.compareTo(amount) >= 0;
    }

    public void deduct(BigDecimal amount) {
        if (canPay(amount)) {
            balance = balance.subtract(amount);
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
}
