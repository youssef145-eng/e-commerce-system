package Products;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpirableProduct extends Product {
    private LocalDate expiryDate;

    public ExpirableProduct(String name, BigDecimal price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }
    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

}
