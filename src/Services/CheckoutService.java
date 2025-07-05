package Services;

import Products.Product;
import Products.Shippable;
import Shopping.Cart;
import Shopping.CartItem;
import Users.Customer;

import java.math.BigDecimal;
import java.util.*;

public class CheckoutService {
    private static final BigDecimal SHIPPING_COST_PER_KG = new BigDecimal("30.0");

    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Shopping.Cart is empty");
        }

        List<Shippable> toShip = new ArrayList<>();
        BigDecimal subtotal = BigDecimal.ZERO;
        for (CartItem item : cart.getItems()) {
            Product product = item.product;
            int quantity = item.quantity;

            if (!product.isAvailable(quantity)) {
                throw new IllegalStateException("Products.Product out of stock: " + product.getName());
            }

            if (product.isExpired()) {
                throw new IllegalStateException("Products.Product expired: " + product.getName());
            }

            BigDecimal itemTotal = product.getPrice().multiply(new BigDecimal(quantity));
            subtotal = subtotal.add(itemTotal);

            if (product instanceof Shippable) {
                for (int i = 0; i < quantity; i++) {
                    toShip.add((Shippable) product);
                }
            }
        }

        BigDecimal totalWeight = toShip.stream()
                .map(Shippable::getWeight)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal shippingCost = totalWeight.compareTo(BigDecimal.ZERO) > 0 ? 
                totalWeight.multiply(SHIPPING_COST_PER_KG) : BigDecimal.ZERO;
        BigDecimal total = subtotal.add(shippingCost);

        if (!customer.canPay(total)) {
            throw new IllegalStateException("Users.Customer has insufficient balance");
        }

        if (!toShip.isEmpty()) {
            ShippingService.ship(toShip);
        }

        customer.deduct(total);

        for (CartItem item : cart.getItems()) {
            item.product.reduceQuantity(item.quantity);
        }

        System.out.println("\n** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            BigDecimal itemTotal = item.product.getPrice().multiply(new BigDecimal(item.quantity));
            System.out.printf("%dx %s\t%s\n", item.quantity, item.product.getName(), itemTotal.toString());
        }
        System.out.println("---------------------");
        System.out.printf("Subtotal\t%s\n", subtotal.toString());
        System.out.printf("Shipping\t%s\n", shippingCost.toString());
        System.out.printf("Amount\t\t%s\n", total.toString());
        System.out.printf("Users.Customer Balance\t%s\n", customer.getBalance().toString());
    }
}
