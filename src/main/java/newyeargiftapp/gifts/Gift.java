package newyeargiftapp.gifts;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import newyeargiftapp.models.Candy;
import newyeargiftapp.models.Chocolate;
import newyeargiftapp.models.Cookie;
import newyeargiftapp.models.Sweets;

public class Gift {
    private List<Sweets> sweetsList = new ArrayList<>();

    // Додаємо нові методи

    // Метод, що перевіряє, чи є в подарунку солодощі
    public boolean hasSweets() {
        return !sweetsList.isEmpty();
    }

    // Метод для перевірки, чи є список солодощів порожнім
    public boolean isEmpty() {
        return sweetsList.isEmpty();
    }

    // Метод для додавання солодощів
    public void addSweet(Sweets sweet) {
        sweetsList.add(sweet);
    }

    // Метод для видалення солодощів за індексом
    public void removeSweet(int index) {
        if (index >= 0 && index < sweetsList.size()) {
            sweetsList.remove(index);
        }
    }

    // Метод для виведення солодощів
    public void displaySweets() {
        if (isEmpty()) {
            System.out.println("Список солодощів порожній.");
            return;
        }
        for (Sweets sweet : sweetsList) {
            System.out.println(sweet);
        }
    }

    // Метод для сортування солодощів за вагою
    public void sortSweets() {
        sweetsList.sort((s1, s2) -> Double.compare(s1.getWeight(), s2.getWeight()));
    }

    // Метод для пошуку солодощів за вмістом цукру
    public void findSweetBySugar(double sugarContent) {
        boolean found = false;
        for (Sweets sweet : sweetsList) {
            if (sweet.getSugarContent() == sugarContent) {
                System.out.println(sweet);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Солодощі з вмістом цукру " + sugarContent + " не знайдено.");
        }
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            System.out.println("Збереження в файл: " + filename);  // Лог для перевірки
            for (Sweets sweet : sweetsList) {
                writer.write(sweet.getClass().getSimpleName() + "," + sweet.getWeight() + "," + sweet.getSugarContent());
                writer.newLine();
            }
            System.out.println("Подарунок успішно збережено у файл: " + filename);
        } catch (IOException e) {
            System.out.println("Помилка при збереженні подарунку: " + e.getMessage());
        }
    }



    // Метод для отримання списку солодощів
    public List<Sweets> getSweetsList() {
        return sweetsList;
    }

    // Метод для завантаження солодощів з файлу
    public void loadFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            sweetsList.clear(); // Очищуємо поточний список перед завантаженням

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 3) {
                    String type = parts[0];
                    double weight = Double.parseDouble(parts[1]);
                    double sugarContent = Double.parseDouble(parts[2]);

                    Sweets sweet = null;
                    switch (type) {
                        case "Candy":
                            sweet = new Candy(weight, sugarContent);
                            break;
                        case "Chocolate":
                            sweet = new Chocolate(weight, sugarContent);
                            break;
                        case "Cookie":
                            sweet = new Cookie(weight, sugarContent);
                            break;
                        default:
                            System.out.println("Невідомий тип солодощів: " + type);
                            continue;
                    }
                    sweetsList.add(sweet);
                }
            }
            System.out.println("Подарунок успішно завантажено з файлу: " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Помилка при завантаженні подарунку: " + e.getMessage());
        }
    }
}
