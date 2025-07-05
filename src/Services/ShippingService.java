package Services;

import Products.Shippable;

import java.math.BigDecimal;
import java.util.List;

public class ShippingService {
    public static void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");
        BigDecimal totalWeight = BigDecimal.ZERO;
        for (Shippable item : items) {
            BigDecimal weightInGrams = item.getWeight().multiply(new BigDecimal("1000"));
            System.out.printf("%s\t%sg\n", item.getName(), weightInGrams.toString());
            totalWeight = totalWeight.add(item.getWeight());
        }
        System.out.printf("Total package weight %skg\n", totalWeight.toString());
    }
}
