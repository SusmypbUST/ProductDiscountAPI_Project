package org.example.model;

import java.util.List;


public class DiscountResponse {
    private List<Product> discountedproducts;
    private double totalSaving;
    private double finalBill;

    public List<Product> getDiscountedproducts() {
        return discountedproducts;
    }



    public double getTotalSaving() {
        return totalSaving;
    }



    public double getFinalBill() {
        return finalBill;
    }



    public DiscountResponse(List<Product> discountedproducts, double totalSaving, double finalBill) {
        this.discountedproducts = discountedproducts;
        this.totalSaving = totalSaving;
        this.finalBill = finalBill;
    }

}