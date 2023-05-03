import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class StreamUtils {
    public static List<Product> getAllBooksWithPriceOver250(List<Product> products) {
        List<Product> sortedProducts = products.stream().
                filter(product -> product.getPrice() >= 250 && product.getType().equals("Book"))
                .collect(Collectors.toList());

        return sortedProducts;
    }

    public static List<Product> getAllBooksWithDiscount(List<Product> products) {
        List<Product> sortedProducts = products.stream()
                .filter(product -> product.getType().equals("Book") && product.isDiscount())
                .map(product -> {
                    product.setPrice(product.getPrice() - (product.getPrice() * 0.1));
                    return product;
                })
                .collect(Collectors.toList());

        return sortedProducts;
    }

    public static Product getTheCheapestBook(List<Product> products) {
        Product productBookMinPrice = products.stream()
                .filter(product -> product.getType().equals("Book"))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Продукт [категорія: Book] не знайдено"));

        return productBookMinPrice;
    }

    public static double getPrice(List<Product> products) {
        double price = products.stream()
                .filter(product2 -> product2.getPrice() < 75 && product2.getType().equals("Book") &&
                        product2.getAddingDate().getYear() == LocalDateTime.now().getYear())
                .mapToDouble((Product product2) -> product2.getPrice())
                .reduce(Double::sum)
                .getAsDouble();

        return price;
    }

    public static List<Product> getThreeLastByDate(List<Product> products) {
        List<Product> lastThree = products.stream()
                .max(Comparator.comparing(Product::getAddingDate))
                .map(latestProduct -> products.stream()
                        .filter(product -> product.getAddingDate().isBefore(latestProduct.getAddingDate().plusSeconds(1)))
                        .sorted(Comparator.comparing(Product::getAddingDate).reversed())
                        .limit(3)
                        .collect(Collectors.toList()))
                .orElseThrow();
        return lastThree;
    }

    public static Map<String, List<Product>> getProductsByCategory(List<Product> products) {
        Map<String, List<Product>> groupedProducts = products.stream()
                .collect(Collectors.groupingBy(Product::getType));
        return groupedProducts;
    }
}
