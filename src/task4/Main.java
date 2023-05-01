package task4;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(getLastByDate());
        System.out.println(getPrice());
    }


    private static double getPrice() {
        List<Product2> product2s = getProducts();
        List<Product2> sortedProduct2s = product2s.stream()
                .filter(product2 -> product2.getPrice() < 75 && product2.getType().equals("Book") &&
                        product2.getAddingDate().getYear() == LocalDateTime.now().getYear())
                .collect(Collectors.toList());

        Double price = sortedProduct2s.stream()
                .mapToDouble((Product2 product2) -> product2.getPrice())
                .reduce( Double::sum)
                .getAsDouble();

        return price;
    }
    private static List<Product2> getLastByDate() {
        List<Product2> product2s = getProducts();
        List<Product2> sortedProduct2s = product2s.stream()
                .sorted(Comparator.comparing((Product2 p) -> p.getAddingDate()).reversed())
                .skip(Math.max(0, product2s.size() - 3))
                .collect(Collectors.toList());
        return sortedProduct2s;
    }

    private static List<Product2> getProducts() {
        List<Product2> product2s = new ArrayList<>();
        product2s.add(new Product2("Book", 70, true, LocalDateTime.now()));
        product2s.add(new Product2("Toy", 30, true, LocalDateTime.now()));
        product2s.add(new Product2("Toy", 50, true, LocalDateTime.now()));
        product2s.add(new Product2("Toy", 150, true, LocalDateTime.now()));
        product2s.add(new Product2("Book", 200, true, LocalDateTime.now()));
        product2s.add(new Product2("Book", 60, true, LocalDateTime.now()));
        return product2s;
    }
}
