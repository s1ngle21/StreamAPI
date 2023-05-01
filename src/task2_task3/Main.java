package task2_task3;

import java.util.*;
import java.util.stream.Collectors;

//2.1 Дан клас Product, який складається з властивостей:
//        - тип
//        - ціна
//        - можливість застосування знижки
//        2.2 Реалізувати метод отримання всіх продуктів як списку, категорія яких еквівалентна “Book”
//        і з можливістю застосування знижки. Фінальний список повинен містити продукти з застосованою знижкою 10%.
//        Так, якщо Продукт A був з ціною 1.0 USD, то його фінальна ціна залишатиметься 0.9 USD
//
//        3.1 Даний клас Product, який складається з властивостей:
//        - тип
//        - ціна
//        - можливість застосування знижки
//        3.2 Реалізувати метод отримання найдешевшого продукту з категорії “Book”
//        3.3 У випадку, якщо жоден продукт не знайдено (ситуація, коли немає продукту з категорією),
//        викинути виняток з повідомленням “Продукт [категорія: ім'я_категорії] не знайдено”.



public class Main {
    public static void main(String[] args) {
        List<Product> products = getProducts();
        getAllBooksWithDiscount(products);
        getTheCheapestBook(products);
    }

    private static void getAllBooksWithDiscount(List<Product> products) {

        List<Product> sortedProducts = products.stream()
                .filter(product -> product.getType().equals("Book") && product.isDiscount())
                .peek(product -> product.setPrice(product.getPrice() - (product.getPrice() * 0.1)))
                .collect(Collectors.toList());

        System.out.println(sortedProducts);
    }

    private static void getTheCheapestBook(List<Product> products) throws NoSuchElementException{

        Product productBookMinPrice = products.stream()
                .filter(product -> product.getType().equals("Book"))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Продукт [категорія: Book] не знайдено"));

        System.out.println(productBookMinPrice);

    }

    private static List<Product> getProducts() {
        return new ArrayList<>(
                Arrays.asList(
                        new Product("Book", 300, true),
                        new Product("Magazine", 150, false),
                        new Product("Book", 400, false),
                        new Product("Paper", 100, false),
                        new Product("Book", 230, true)
                )
        );
    }
}
