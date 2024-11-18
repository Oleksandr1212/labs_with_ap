package newyeargiftapp.commands;

import newyeargiftapp.gifts.Gift;
import newyeargiftapp.models.Sweets;
import newyeargiftapp.models.Candy;
import newyeargiftapp.models.Chocolate;
import newyeargiftapp.models.Cookie;
import java.util.Scanner;
import java.util.InputMismatchException;

public class AddSweetCommand implements Command {
    private Gift gift;

    public AddSweetCommand(Gift gift) {
        this.gift = gift;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        // Вибір типу солодощів
        System.out.println("Оберіть тип солодощів:");
        System.out.println("1 - Цукерка");
        System.out.println("2 - Шоколад");
        System.out.println("3 - Печиво");
        System.out.print("Ваш вибір: ");

        int choice = 0;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Невірний ввід для вибору типу солодощів.");
            scanner.nextLine(); // очищаємо буфер
            return;
        }

        double weight = 0;
        System.out.print("Введіть вагу солодощів: ");
        try {
            weight = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Невірний ввід для ваги.");
            scanner.nextLine(); // очищаємо буфер
            return;
        }

        double sugarContent = 0;
        System.out.print("Введіть вміст цукру: ");
        try {
            sugarContent = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Невірний ввід для вмісту цукру.");
            scanner.nextLine(); // очищаємо буфер
            return;
        }

        Sweets sweet = null;

        switch (choice) {
            case 1:
                sweet = new Candy(weight, sugarContent);
                System.out.println("Цукерку додано до подарунка.");
                break;
            case 2:
                sweet = new Chocolate(weight, sugarContent);
                System.out.println("Шоколад додано до подарунка.");
                break;
            case 3:
                sweet = new Cookie(weight, sugarContent);
                System.out.println("Печиво додано до подарунка.");
                break;
            default:
                System.out.println("Невірний вибір. Солодощі не додано.");
                return;
        }

        gift.addSweet(sweet);
    }
}
