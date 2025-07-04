package Services;

import Products.Product;
import Products.Shippable;
import Shopping.Cart;
import Shopping.CartItem;
import Users.Customer;

import java.util.*;

public class CheckoutService {
    private static final double SHIPPING_COST_PER_KG = 30.0;

    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Shopping.Cart is empty");
        }

        List<Shippable> toShip = new ArrayList<>();
        double subtotal = 0.0;
        for (CartItem item : cart.getItems()) {
            Product product = item.product;
            int quantity = item.quantity;

            if (!product.isAvailable(quantity)) {
                throw new IllegalStateException("Products.Product out of stock: " + product.getName());
            }

            if (product.isExpired()) {
                throw new IllegalStateException("Products.Product expired: " + product.getName());
            }

            double itemTotal = product.getPrice() * quantity;
            subtotal += itemTotal;

            if (product instanceof Shippable) {
                for (int i = 0; i < quantity; i++) {
                    toShip.add((Shippable) product);
                }
            }
        }

        double totalWeight = toShip.stream().mapToDouble(Shippable::getWeight).sum();
        double shippingCost = totalWeight > 0 ? SHIPPING_COST_PER_KG : 0;
        double total = subtotal + shippingCost;

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
            System.out.printf("%dx %s\t%.0f\n", item.quantity, item.product.getName(), item.product.getPrice() * item.quantity);
        }
        System.out.println("---------------------");
        System.out.printf("Subtotal\t%.0f\n", subtotal);
        System.out.printf("Shipping\t%.0f\n", shippingCost);
        System.out.printf("Amount\t\t%.0f\n", total);
        System.out.printf("Users.Customer Balance\t%.0f\n", customer.getBalance());
    }
}
