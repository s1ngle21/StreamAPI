import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;

public class GetProducts {

    public static List<Product> getProducts() {
        List<Product> product2s = new ArrayList<>();
        product2s.add(new Product("Book", 70, true, LocalDateTime.now()));
        product2s.add(new Product("Toy", 30, true, LocalDateTime.now()));
        product2s.add(new Product("Toy", 50, true, LocalDateTime.now()));
        product2s.add(new Product("Toy", 150, true, LocalDateTime.now()));
        product2s.add(new Product("Book", 250, true, LocalDateTime.now()));
        product2s.add(new Product("Book", 60, true, LocalDateTime.now()));
        return product2s;
    }
}
