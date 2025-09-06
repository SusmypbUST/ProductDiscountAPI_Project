import static org.junit.jupiter.api.Assertions.*;

import org.example.model.DiscountResponse;
import org.example.model.Product;
import org.example.service.ProductDiscountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ProductDiscountServiceTest {

    private ProductDiscountService service;

    @BeforeEach
    public void setup() {
        service = new ProductDiscountService();
    }

    @Test
    public void testElectronicsDiscount() {
        Product p = new Product(1, "laptop", "electronics", 50000, 1);
        DiscountResponse response = service.applyDiscounts(Arrays.asList(p));
        assertEquals(5000, response.getTotalSaving(), 0.001);
        assertEquals(45000, response.getFinalBill(), 0.001);
    }

    @Test
    public void testClothingDiscount() {
        Product p = new Product(2, "tshirt", "clothing", 1000, 3);
        DiscountResponse response = service.applyDiscounts(Arrays.asList(p));
        // 1 free tshirt = 1000 saving
        assertEquals(1000, response.getTotalSaving(), 0.001);
        assertEquals(2000, response.getFinalBill(), 0.001);
    }

    @Test
    public void testGroceryDiscount() {
        Product p = new Product(3, "rice", "grocery", 100, 10);
        DiscountResponse response = service.applyDiscounts(Arrays.asList(p));
        // 5% of (100*10)=50 saving
        assertEquals(50, response.getTotalSaving(), 0.001);
        assertEquals(950, response.getFinalBill(), 0.001);
    }

    @Test
    public void testInvalidQuantityOrPrice() {
        Product p1 = new Product(4, "item1", "electronics", 1000, 0);
        Product p2 = new Product(5, "item2", "clothing", -100, 2);

        assertThrows(IllegalArgumentException.class, () -> service.applyDiscounts(Arrays.asList(p1)));
        assertThrows(IllegalArgumentException.class, () -> service.applyDiscounts(Arrays.asList(p2)));
    }

    @Test
    public void testMultipleProducts() {
        Product p1 = new Product(1, "laptop", "electronics", 50000, 1);
        Product p2 = new Product(2, "tshirt", "clothing", 1000, 3);
        Product p3 = new Product(3, "rice", "grocery", 100, 10);

        DiscountResponse response = service.applyDiscounts(Arrays.asList(p1, p2, p3));
        assertEquals(5000 + 1000 + 50, response.getTotalSaving(), 0.001);
        assertEquals((50000 + 3000 + 1000) - (5000 + 1000 + 50), response.getFinalBill(), 0.001);
    }
}