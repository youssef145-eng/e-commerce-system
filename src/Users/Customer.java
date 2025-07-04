package Users;

public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public boolean canPay(double amount) {
        return balance >= amount;
    }

    public void deduct(double amount) {
        if (canPay(amount)) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
}
