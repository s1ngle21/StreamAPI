package task2_task3;

    public class Product {
        private String type;
        private double price;
        private boolean discount;

        public Product(String type, double price, boolean discount) {
            this.type = type;
            this.price = price;
            this.discount = discount;
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

        public void setPrice(double price) {
            this.price = price;
        }

        public boolean isDiscount() {
            return discount;
        }

        public void setDiscount(boolean discount) {
            this.discount = discount;
        }

        @Override
        public String toString() {
            return "Product2{" +
                    "type='" + type + '\'' +
                    ", price=" + price +
                    ", discount=" + discount +
                    '}';
        }
    }


