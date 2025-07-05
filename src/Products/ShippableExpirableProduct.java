package Products;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ShippableExpirableProduct extends ExpirableProduct implements Shippable {
    private BigDecimal weight;

    public ShippableExpirableProduct(String name, BigDecimal price, int quantity, LocalDate expiryDate, BigDecimal weight) {
        super(name, price, quantity, expiryDate);
        this.weight = weight;
    }

    @Override
    public BigDecimal getWeight() {
        return weight;
    }
}
