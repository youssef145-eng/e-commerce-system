import Products.Product;
import Products.ShippableExpirableProduct;
import Products.ShippableProduct;
import Services.CheckoutService;
import Shopping.Cart;
import Users.Customer;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product cheese = new ShippableExpirableProduct("Cheese", new BigDecimal("100"), 5, LocalDate.of(2025, 12, 1), new BigDecimal("0.2"));
        Product biscuits = new ShippableExpirableProduct("Biscuits", new BigDecimal("150"), 3, LocalDate.of(2025, 8, 1), new BigDecimal("0.7"));
        Product tv = new ShippableProduct("TV", new BigDecimal("300"), 3, new BigDecimal("5.0"));
        Product scratchCard = new Product("ScratchCard", new BigDecimal("50"), 10);

        Customer customer = new Customer("Youssef", new BigDecimal("1000"));

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);

        CheckoutService.checkout(customer, cart);
    }
}
