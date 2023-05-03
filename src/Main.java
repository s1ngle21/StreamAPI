import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = GetProducts.getProducts();

        System.out.println(StreamUtils.getAllBooksWithPriceOver250(products));

        System.out.println(StreamUtils.getAllBooksWithDiscount(products));
        System.out.println(StreamUtils.getTheCheapestBook(products));

        System.out.println(StreamUtils.getThreeLastByDate(products));
        System.out.println(StreamUtils.getPrice(products));

        System.out.println(StreamUtils.getProductsByCategory(products));
    }
}
