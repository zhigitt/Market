import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Card card = new Card("Zhigit","Turumbekov", "4444", 2000, "1234");

        Basket basket = new Basket();
        basket.addProduct(new Product("imonade", 80));
        basket.addProduct(new Product("kartoshka", 50));
        basket.addProduct(new Product("piyaz", 30));
        basket.addProduct(new Product("sabiz", 70));


        Client client = new Client("Zhigit", "Turumbekov", 22,card, basket);

        client.payWithCard(card.balance);

        System.out.println("Balance: " + client.getCardBalance());
    }
}