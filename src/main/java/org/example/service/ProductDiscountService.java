package org.example.service;

import org.example.model.DiscountResponse;
import org.example.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductDiscountService {

    public DiscountResponse applyDiscounts(List<Product> products) {
        final double[] totalSaving = {0};
        final double[] finalBill = {0};
         // Validate input
        for (Product p : products) {
            if (p.getPrice() <= 0 || p.getQuantity() <= 0) {
                throw new IllegalArgumentException("Price and Quantity must be > 0");
            }
        }

        // Process discounts
        List<Product> discountedProducts = products.stream().map(product -> {
            double saving = 0;
            String category = product.getCategory().toLowerCase();

            switch (category) {
                case "electronics":
                    if (product.getPrice() >= 20000) {
                        saving = product.getPrice() * product.getQuantity() * 0.10;
                    }
                    break;
                case "clothing":
                    if (product.getQuantity() >= 3) {
                        // Buy 2 get 1 free
                        int freeItems = product.getQuantity() / 3;
                        saving = freeItems * product.getPrice();
                    }
                    break;
                case "grocery":
                    if (product.getQuantity() >= 10) {
                        saving = product.getPrice() * product.getQuantity() * 0.05;
                    }
                    break;
                default:
                    // No discount for unknown categories
                    saving = 0;
                    break;
            }

            totalSaving[0] += saving;
            finalBill[0] += (product.getPrice() * product.getQuantity()) - saving;

            return product;
        }).collect(Collectors.toList());

        return new DiscountResponse(discountedProducts, totalSaving[0], finalBill[0]);
    }

}


