package Services;

import Products.Shippable;

import java.util.List;

public class ShippingService {
    public static void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0.0;
        for (Shippable item : items) {
            System.out.printf("%s\t%.0fg\n", item.getName(), item.getWeight() * 1000);
            totalWeight += item.getWeight();
        }
        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}
