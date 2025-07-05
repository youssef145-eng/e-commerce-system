# E-Commerce System

A Java-based e-commerce system demonstrating Object-Oriented Programming principles with a focus on inheritance, interfaces, and polymorphism.

## 🚀 Features

- **Product Management**: Support for different types of products (regular, shippable, expirable, and shippable-expirable)
- **Shopping Cart**: Add products to cart with quantity validation
- **Customer Management**: Customer accounts with balance tracking
- **Checkout System**: Complete checkout process with shipping cost calculation
- **Inventory Management**: Automatic stock reduction after purchase
- **Expiry Date Validation**: Prevents purchase of expired products

## 🏗️ Architecture

### Product Hierarchy
- **Product**: Base class for all products
- **ExpirableProduct**: Extends Product with expiry date functionality
- **ShippableProduct**: Extends Product and implements Shippable interface
- **ShippableExpirableProduct**: Combines both shippable and expirable features

### Key Design Patterns
- **Inheritance**: Product hierarchy demonstrates proper inheritance
- **Interfaces**: Shippable interface for polymorphic behavior
- **Composition**: Cart contains CartItems
- **Service Layer**: Business logic separated into service classes

## 🛠️ How to Run

### Prerequisites
- Java 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

### Running the Application
1. Clone or download the project
2. Open the project in your Java IDE
3. Run the `Main.java` file

### Command Line (if compiled)
```bash
# Compile all Java files
javac -d out src/**/*.java src/Main.java

# Run the application
java -cp out Main
```

## 📋 Sample Output

When you run the application, you'll see output similar to:

```
** Shipment notice **
Cheese	200g
Biscuits	700g
Total package weight 0.9kg

** Checkout receipt **
2x Cheese	200
1x Biscuits	150
1x ScratchCard	50
---------------------
Subtotal	400
Shipping	27
Amount		427
Customer Balance	573
```

## 🎯 Key Features Explained

### Product Types
- **Regular Products**: Basic products like scratch cards
- **Shippable Products**: Physical items that need shipping (e.g., TV)
- **Expirable Products**: Items with expiry dates (e.g., food items)
- **Shippable Expirable Products**: Items that are both physical and have expiry dates (e.g., cheese, biscuits)

### Shopping Process
1. **Add to Cart**: Products are added with quantity validation
2. **Stock Check**: Ensures sufficient inventory
3. **Expiry Check**: Prevents purchase of expired items
4. **Shipping Calculation**: Calculates shipping costs for physical items
5. **Payment Processing**: Validates customer balance and processes payment
6. **Inventory Update**: Reduces stock quantities
7. **Shipping**: Generates shipping notices for physical items

### Business Rules
- Customers cannot purchase more items than available in stock
- Expired products cannot be purchased
- Shipping costs are calculated per kilogram (30.0 per kg)
- Customer balance must be sufficient for total purchase amount

## 🔧 Extensibility

The system is designed to be easily extensible:
- Add new product types by extending the Product class
- Implement new interfaces for additional behaviors
- Add new services for additional business logic
- Extend the shopping cart with new features

## 📚 Learning Objectives

This project demonstrates:
- **Object-Oriented Programming** principles
- **Inheritance** and **Polymorphism**
- **Interface** implementation
- **Service Layer** architecture
- **Exception Handling**
- **Collections** and **Streams** usage
- **Date/Time** handling with LocalDate

## 🤝 Contributing

Feel free to extend this project by:
- Adding new product types
- Implementing a database layer
- Adding user authentication
- Creating a web interface
- Adding payment gateway integration

## 📄 License

This project is created for educational purposes to demonstrate OOP concepts in Java. 