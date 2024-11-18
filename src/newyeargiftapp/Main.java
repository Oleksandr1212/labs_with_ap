package newyeargiftapp;

import newyeargiftapp.menu.Menu;
import newyeargiftapp.gifts.Gift;
import newyeargiftapp.commands.*;
import java.util.Scanner;

public class  Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Gift gift = new Gift();

        // Додавання команд до меню
        menu.setCommand(1, new AddSweetCommand(gift));
        menu.setCommand(2, new SortSweetsCommand(gift));
        menu.setCommand(3, new FindSweetCommand(gift));
        menu.setCommand(4, new DisplaySweetsCommand(gift));
        menu.setCommand(5, new RemoveSweetCommand(gift));
        menu.setCommand(6, new SaveGiftCommand(gift));
        menu.setCommand(7, new LoadGiftCommand(gift));

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            // Виводимо меню
            System.out.println("Меню:");
            System.out.println("1 - Додати солодощі до подарунку");
            System.out.println("2 - Відсортувати солодощі за вагою");
            System.out.println("3 - Знайти солодощі за вмістом цукру");
            System.out.println("4 - Вивести всі солодощі");
            System.out.println("5 - Видалити солодощі за списком");
            System.out.println("6 - Зберегти подарунок у файл");
            System.out.println("7 - Завантажити подарунок із файлу");
            System.out.println("8 - Вийти");

            // Зчитуємо вибір користувача
            System.out.print("Виберіть опцію: ");
            option = scanner.nextInt();

            if (option >= 1 && option < 8) {
                menu.selectOption(option);
            } else if (option != 8) {
                System.out.println("Невірна опція. Спробуйте ще раз.");
            }
        } while (option != 8); // Вихід з циклу, якщо користувач вибере 8

        System.out.println("Дякуємо за використання програми! Вихід.");
        scanner.close();
    }
}