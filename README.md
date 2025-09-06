# Product Discount API

This REST API calculates discounts for a list of purchased products based on specific category-wise discount rules. It returns the discounted product list along with total savings and final bill.

---

## Endpoint

**POST** `/products/discount`

---

## Request Body

```json
{
  "products": [
    {
      "id": 1,
      "name": "laptop",
      "category": "electronice",
      "price": 50000,
      "quantity": 1
    },
    {
      "id": 2,
      "name": "laptop",
      "category": "electronice",
      "price": 50000,
      "quantity": 1
    }
]}

```

## Response Body


```json
{
  "discountedproducts": [
    {
      "id": 1,
      "name": "laptop",
      "category": "electronice",
      "price": 50000,
      "quantity": 1
    },
    {
      "id": 2,
      "name": "laptop",
      "category": "electronice",
      "price": 50000,
      "quantity": 1
    }
  ],
  "totalSaving": 6060,
  "finalBill": 48140
}
 
```

## Discount Rules
| Rule No. | Description                                          | Matching Test Case           |
| -------- | ---------------------------------------------------- | ---------------------------- |
| 1        | Electronics: 10% discount if price ≥ 20000           | `testElectronicsDiscount`    |
| 2        | Clothing: Buy 2 get 1 free (applies if quantity ≥ 3) | `testClothingDiscount`       |
| 3        | Grocery: 5% discount if quantity ≥ 10                | `testGroceryDiscount`        |
| 4        | Reject product if quantity ≤ 0 or price ≤ 0          | `testInvalidQuantityOrPrice` |


## Technologies Used

-> Java 8+

-> Spring Boot

-> Maven / Gradle

-> JUnit (for testing)

-> REST (JSON API)

-> Postman

## Project Components
### Product Class

Represents a product with fields: id, name, category, price, and quantity.

### ProductRequest Class

Contains a list of input products for processing.

### ProductResponse Class

Returns:

List of valid products with prices/quantities

Total savings

Final amount to be paid

### DiscountService Class

Implements business rules:

Applies relevant discount logic based on category

Skips invalid products (quantity ≤ 0 or price ≤ 0)

Calculates total savings and final bill using Java 8 Streams

### ProductController Class

Handles POST /products/discount endpoint and delegates to the service.

### ProductDiscountTests Class

JUnit tests validating all discount rules and expected behavior.

## Running Tests

Unit tests ensure all business rules are correctly implemented and can be run with your preferred test runner.
