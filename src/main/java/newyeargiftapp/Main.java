package newyeargiftapp;

import newyeargiftapp.menu.Menu;
import newyeargiftapp.gifts.Gift;
import newyeargiftapp.commands.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static final Logger logger = LogManager.getLogger(Main.class);

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
        menu.setCommand(8, new TriggerErrorCommand());

        Scanner scanner = new Scanner(System.in);
        int option = 0;
        logger.info("Програма запущена");

        // Основний цикл для відображення меню і зчитування вибору користувача
        do {
            logger.info("Меню відображено користувачу");
            displayMenu(); // Виводимо меню

            // Зчитуємо вибір користувача
            try {
                option = getUserInput(scanner); // Отримуємо ввід

                // Логуємо вибір користувача
                if (option >= 1 && option <= 8) {
                    menu.selectOption(option); // Обирає опцію
                    logger.info("Користувач обрав опцію: " + option);
                } else {
                    logger.warn("Невірна опція вибрана: " + option);
                    System.out.println("Невірна опція. Спробуйте ще раз.");
                }
            } catch (Exception e) {
                logger.error("Сталася помилка: " + e.getMessage(), e);
                System.out.println("Сталася помилка: " + e.getMessage());
            }
        } while (option != 9); // Вихід з циклу, якщо користувач вибере 8

        System.out.println("Дякуємо за використання програми! Вихід.");
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Меню:");
        System.out.println("1 - Додати солодощі до подарунку");
        System.out.println("2 - Відсортувати солодощі за вагою");
        System.out.println("3 - Знайти солодощі за вмістом цукру");
        System.out.println("4 - Вивести всі солодощі");
        System.out.println("5 - Видалити солодощі за списком");
        System.out.println("6 - Зберегти подарунок у файл");
        System.out.println("7 - Завантажити подарунок із файлу");
        System.out.println("8 - Викликати помилку");
        System.out.println("9 - Вийти");
    }

    // Метод для отримання вводу користувача з обробкою помилок
    private static int getUserInput(Scanner scanner) {
        while (true) {
            System.out.print("Виберіть опцію: ");
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                logger.warn("Некоректний ввід користувача: " + e.getMessage());
                System.out.println("Будь ласка, введіть число.");
                scanner.next(); // Пропускаємо некоректний ввід
            }
        }
    }
}
