package task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//1.1 Дан клас Product, який складається з властивостей:
//        - тип
//        - ціна
//        1.2 Реалізувати метод отримання всіх продуктів у вигляді списку, категорія яких еквівалентна “Book” та ціна більш ніж 250.

public class Main {
    public static void main(String[] args) {
        getAllBooksWithPriceOver250();

    }

    private static void getAllBooksWithPriceOver250() {
        List<Product1> products = getProducts();

        List<Product1> sortedProducts = products.stream().
                filter(product -> product.getPrice() > 250 && product.getType().equals("Book"))
                .collect(Collectors.toList());

        System.out.println(sortedProducts);
    }

    private static List<Product1> getProducts() {
        return new ArrayList<>(
                Arrays.asList(
                        new Product1("Book", 300),
                        new Product1("Magazine", 150),
                        new Product1("Book", 400),
                        new Product1("Paper", 100),
                        new Product1("Book", 230)
                )
        );
    }
}
