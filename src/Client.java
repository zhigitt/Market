import java.time.ZonedDateTime;
import java.util.Scanner;

public class Client extends Card implements CardInterface {
    protected int age;
    protected Card card;
    protected Basket basket;
    protected double ostatokBalance = 0;

    public Client() {
    }

    public Client(String firstName, String lastName, int age, Card card, Basket basket) {
        super(firstName, lastName, card.cardNumber, card.balance, card.password);
        this.age = age;
        this.card = card;
        this.basket = basket;
    }

    @Override
    public void payWithCard(double money) {
        double totalMoney = 0;

        for (int i = 0; i < basket.counter; i++) {
            totalMoney += basket.products[i].price;
        }


        if (totalMoney >= 100) {
            System.out.print("Write password: ");
            String passSc = new Scanner(System.in).nextLine();
            if (checkPassword(passSc)) {
                if (balance >= totalMoney) {
                    balance -= totalMoney;
                    for (int i = 0; i < basket.counter; i++) {
                        System.out.println(basket.products[i].productname + " " + basket.products[i].price + " som");
                    }
                    System.out.println("Obshiy summa: " + totalMoney + " som. \nDate: " + ZonedDateTime.now());
                    ostatokBalance = card.balance;
                    ostatokBalance -= totalMoney;
                } else {
                    System.out.println("Balance jetishsiz");
                }
            } else {
                System.out.println("ERROR PASSWORD");
            }
        } else {
            if (balance >= totalMoney) {
                balance -= totalMoney;
                for (int i = 0; i < basket.counter; i++) {
                    System.out.println(basket.products[i].productname + " " + basket.products[i].price + " som");
                }
                System.out.println("Obshiy summa: " + totalMoney + " som. Date: " + ZonedDateTime.now());
                ostatokBalance = card.balance;
                ostatokBalance -= totalMoney;
            } else {
                System.out.println("Balance jetishsiz");
            }
        }

    }

    @Override
    public double getCardBalance() {
        return ostatokBalance;
    }
}
