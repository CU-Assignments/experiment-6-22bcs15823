import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
}

public class ProductProcessing {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 800),
            new Product("Phone", "Electronics", 500),
            new Product("TV", "Electronics", 1000),
            new Product("Sofa", "Furniture", 700),
            new Product("Table", "Furniture", 300),
            new Product("Chair", "Furniture", 150)
        );

        // Group products by category
        Map<String, List<Product>> groupedByCategory = products.stream()
            .collect(Collectors.groupingBy(p -> p.category));

        // Find the most expensive product in each category
        Map<String, Optional<Product>> mostExpensiveInCategory = products.stream()
            .collect(Collectors.groupingBy(p -> p.category,
                Collectors.maxBy(Comparator.comparingDouble(p -> p.price))));

        // Calculate the average price of all products
        double averagePrice = products.stream()
            .mapToDouble(p -> p.price)
            .average()
            .orElse(0);

        System.out.println("Products grouped by category:");
        groupedByCategory.forEach((category, prodList) -> 
            System.out.println(category + " -> " + prodList.stream()
            .map(p -> p.name)
            .collect(Collectors.joining(", ")))
        );

        System.out.println("\nMost expensive product in each category:");
        mostExpensiveInCategory.forEach((category, product) -> 
            System.out.println(category + " -> " + product.get().name + " ($" + product.get().price + ")")
        );

        System.out.println("\nAverage price of all products: $" + averagePrice);
    }
}
