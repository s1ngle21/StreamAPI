package task4;

import java.time.LocalDateTime;

public class Product2 {
    private String type;
    private double price;
    private boolean discount;
    private LocalDateTime addingDate;

    public Product2(String type, double price, boolean discount, LocalDateTime addingDate) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.addingDate = addingDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", addingDate=" + addingDate +
                "}\n";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public LocalDateTime getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(LocalDateTime addingDate) {
        this.addingDate = addingDate;
    }
}
