import java.util.Arrays;

public class Basket extends Product {
    protected Product[] products;
    protected int counter;

    public Basket() {
        this.products = new Product[0];
        this.counter = 0;
    }

    public Basket(String productname, double price, int counter, Product[] products) {
        super(productname, price);
        this.products = products;
        this.counter = counter;
    }

    public Product[] addProduct(Product product) {
        products = Arrays.copyOf(products, products.length + 1);
        products[products.length - 1] = product;
        counter++;
        return products;
    }

}
