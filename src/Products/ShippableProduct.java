package Products;

import java.math.BigDecimal;

public class ShippableProduct extends Product implements Shippable {
    private BigDecimal weight;

    public ShippableProduct(String name, BigDecimal price, int quantity, BigDecimal weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public BigDecimal getWeight() {
        return weight;
    }
}
