package task5;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(getProductsByCategory());
    }


    private static Map<String, List<Product3>> getProductsByCategory() {
        List<Product3> products = getProducts();
        Map<String, List<Product3>> groupedProducts = products.stream()
                .collect(Collectors.groupingBy(Product3::getType));
        return groupedProducts;
    }


    private static List<Product3> getProducts() {
        List<Product3> products = new ArrayList<>();
        products.add(new Product3(12,"Book", 70, true, LocalDateTime.now()));
        products.add(new Product3(13,"Toy", 30, false, LocalDateTime.now()));
        products.add(new Product3(14,"Toy", 50, true, LocalDateTime.now()));
        products.add(new Product3(15,"Toy", 150, false, LocalDateTime.now()));
        products.add(new Product3(16,"Book", 200, true, LocalDateTime.now()));
        products.add(new Product3(17,"Book", 60, false, LocalDateTime.now()));
        return products;
    }
}
