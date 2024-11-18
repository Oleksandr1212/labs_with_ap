package game;

import droids.*;
import weapons.*;
import droids.utils.AnsiColors;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BattleGame {
    private List<Droid> droids = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private StringBuilder battleLog = new StringBuilder(); // Лог бою для запису в файл

    public void start() {
        while (true) {
            System.out.println("\n--- МЕНЮ ---");
            System.out.println("1. Створити дроїда");
            System.out.println("2. Показати список дроїдів");
            System.out.println("3. Бій 1 на 1");
            System.out.println("4. Командний бій");
            System.out.println("5. Записати бій у файл");
            System.out.println("6. Завантажити бій з файлу");
            System.out.println("7. Вийти");
            System.out.print("Виберіть команду: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createDroid();
                    break;
                case 2:
                    showDroids();
                    break;
                case 3:
                    fight();
                    break;
                case 4:
                    teamFight();
                    break;
                case 5:
                    saveFightToFile();
                    break;
                case 6:
                    loadFightFromFile();
                    break;
                case 7:
                    System.out.println("Вихід з гри.");
                    return;
                default:
                    System.out.println("Невірна команда.");
            }
        }
    }

    private void createDroid() {
        System.out.println("1. BattleDroid");
        System.out.println("2. ArmedDroid");
        System.out.println("3. MedicDroid");
        System.out.println("4. LuckyDroid");
        System.out.print("Виберіть тип дроїда: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Споживає новий рядок

        System.out.print("Введіть ім'я дроїда: ");
        String name = scanner.nextLine();

        switch (choice) {
            case 1:
                droids.add(new BattleDroid(name));
                break;
            case 2:
                Random random = new Random();
                Weapon weapon = random.nextBoolean() ? new PositiveWeapon() : new NegativeWeapon();
                droids.add(new ArmedDroid(name, weapon));
                break;
            case 3:
                droids.add(new MedicDroid(name));
                break;
            case 4:
                droids.add(new LuckyDroid(name));
                break;
            default:
                System.out.println("Невірний вибір дроїда.");
        }
    }

    private void showDroids() {
        if (droids.isEmpty()) {
            System.out.println("Список дроїдів порожній.");
            return;
        }
        System.out.println("Список створених дроїдів:");
        for (int i = 0; i < droids.size(); i++) {
            System.out.println((i + 1) + ". " + droids.get(i).getName() + " (Здоров'я: " + droids.get(i).getHealth() + ", Шкода: " + droids.get(i).getDamage() + ")");
        }
    }

    private void displayDroidList() {
        for (int i = 0; i < droids.size(); i++) {
            System.out.println((i + 1) + ". " + droids.get(i).getName() + " (Health: " + droids.get(i).getHealth() + ")");
        }
    }
    private void fight() {
        if (droids.size() < 2) {
            System.out.println("Для бою потрібно щонайменше два дроїди.");
            return;
        }

        System.out.println("Виберіть дроїдів для бою:");
        for (int i = 0; i < droids.size(); i++) {
            System.out.println((i + 1) + ". " + droids.get(i).getName());
        }
        System.out.print("Виберіть першого дроїда (номер): ");
        int firstDroidIndex = scanner.nextInt() - 1;
        System.out.print("Виберіть другого дроїда (номер): ");
        int secondDroidIndex = scanner.nextInt() - 1;

        Droid firstDroid = droids.get(firstDroidIndex);
        Droid secondDroid = droids.get(secondDroidIndex);

        System.out.println(AnsiColors.CYAN + "Бій між " + firstDroid.getName() + " та " + secondDroid.getName() + " починається!" + AnsiColors.RESET);
        battleLog.append("Бій між ").append(firstDroid.getName()).append(" та ").append(secondDroid.getName()).append(":\n");

        while (firstDroid.getHealth() > 0 && secondDroid.getHealth() > 0) {
            firstDroid.attack(secondDroid);
            System.out.println(AnsiColors.RED + firstDroid.getName() + " атакує " + secondDroid.getName() + AnsiColors.RESET);
            battleLog.append(firstDroid.getName()).append(" атакував ").append(secondDroid.getName()).append(", залишилося ").append(secondDroid.getHealth()).append(" здоров'я.\n");

            // Перевірка, чи загинув дроїд
            if (secondDroid.getHealth() <= 0) {
                System.out.println(AnsiColors.YELLOW + secondDroid.getName() + " загинув!" + AnsiColors.RESET);
                battleLog.append(secondDroid.getName()).append(" загинув!\n");
                break;
            }

            secondDroid.attack(firstDroid);
            System.out.println(AnsiColors.RED + secondDroid.getName() + " атакує " + firstDroid.getName() + AnsiColors.RESET);
            battleLog.append(secondDroid.getName()).append(" атакував ").append(firstDroid.getName()).append(", залишилося ").append(firstDroid.getHealth()).append(" здоров'я.\n");

            // Перевірка, чи загинув дроїд
            if (firstDroid.getHealth() <= 0) {
                System.out.println(AnsiColors.YELLOW + firstDroid.getName() + " загинув!" + AnsiColors.RESET);
                battleLog.append(firstDroid.getName()).append(" загинув!\n");
                break;
            }
        }

        // Оголошення переможця
        if (firstDroid.getHealth() <= 0 && secondDroid.getHealth() <= 0) {
            System.out.println(AnsiColors.PURPLE + "Обидва дроїди загинули!" + AnsiColors.RESET);
            battleLog.append("Обидва дроїди загинули!\n");
        } else if (firstDroid.getHealth() <= 0) {
            System.out.println(AnsiColors.GREEN + secondDroid.getName() + " переміг!" + AnsiColors.RESET);
            battleLog.append(secondDroid.getName()).append(" переміг!\n");
        } else {
            System.out.println(AnsiColors.GREEN + firstDroid.getName() + " переміг!" + AnsiColors.RESET);
            battleLog.append(firstDroid.getName()).append(" переміг!\n");
        }
    }



    // Додатковий метод для відображення стану дроїдів
    private void displayDroidStatus(Droid firstDroid, Droid secondDroid) {
        System.out.println("\nСтан дроїдів:");
        System.out.println(firstDroid.getName() + " - Здоров'я: " + firstDroid.getHealth());
        System.out.println(secondDroid.getName() + " - Здоров'я: " + secondDroid.getHealth());
        System.out.println("--------------------------");
    }


    private void teamFight() {
        if (droids.size() < 4) {
            System.out.println(AnsiColors.RED + "Для командного бою потрібно щонайменше чотири дроїди." + AnsiColors.RESET);
            return;
        }

        System.out.print("Введіть кількість дроїдів у кожній команді: ");
        int teamSize = scanner.nextInt();

        if (teamSize < 1 || teamSize > droids.size() / 2) {
            System.out.println(AnsiColors.RED + "Кількість дроїдів у команді має бути між 1 і " + (droids.size() / 2) + "." + AnsiColors.RESET);
            return;
        }

        List<Droid> firstTeam = selectTeam(teamSize);
        List<Droid> secondTeam = selectTeam(teamSize);

        System.out.println(AnsiColors.YELLOW + "Командний бій починається між командами!" + AnsiColors.RESET);
        battleLog.append("Командний бій починається між командами:\n");

        while (!firstTeam.isEmpty() && !secondTeam.isEmpty()) {
            for (Droid attacker : firstTeam) {
                if (secondTeam.isEmpty()) break;
                Droid target = secondTeam.get(new Random().nextInt(secondTeam.size()));
                System.out.println(AnsiColors.CYAN + attacker.getName() + " атакує " + target.getName() + AnsiColors.RESET);
                attacker.attack(target);
                System.out.println(AnsiColors.GREEN + target.getName() + " має " + target.getHealth() + " HP залишилося." + AnsiColors.RESET);
                if (!target.isAlive()) {
                    System.out.println(AnsiColors.RED + target.getName() + " загинув!" + AnsiColors.RESET);
                    secondTeam.remove(target);
                }
            }

            for (Droid attacker : secondTeam) {
                if (firstTeam.isEmpty()) break;
                Droid target = firstTeam.get(new Random().nextInt(firstTeam.size()));
                System.out.println(AnsiColors.CYAN + attacker.getName() + " атакує " + target.getName() + AnsiColors.RESET);
                attacker.attack(target);
                System.out.println(AnsiColors.GREEN + target.getName() + " має " + target.getHealth() + " HP залишилося." + AnsiColors.RESET);
                if (!target.isAlive()) {
                    System.out.println(AnsiColors.RED + target.getName() + " загинув!" + AnsiColors.RESET);
                    firstTeam.remove(target);
                }
            }
        }

        if (firstTeam.isEmpty()) {
            System.out.println(AnsiColors.PURPLE + "Перемогла команда 2!" + AnsiColors.RESET);
        } else {
            System.out.println(AnsiColors.PURPLE + "Перемогла команда 1!" + AnsiColors.RESET);
        }
    }


    // Метод для вибору команди
    private List<Droid> selectTeam(int teamSize) {
        List<Droid> team = new ArrayList<>();
        displayDroidList();

        for (int i = 0; i < teamSize; i++) {
            System.out.print("Виберіть номер дроїда для команди (не вибирайте того самого дроїда кілька разів): ");
            int droidIndex = scanner.nextInt() - 1;

            if (droidIndex < 0 || droidIndex >= droids.size()) {
                System.out.println("Невірний номер дроїда. Спробуйте ще раз.");
                i--;
                continue;
            }

            Droid selectedDroid = droids.get(droidIndex);
            if (team.contains(selectedDroid)) {
                System.out.println("Цей дроїд уже вибраний. Спробуйте іншого.");
                i--;
            } else {
                team.add(selectedDroid);
            }
        }
        return team;
    }

    // Метод для відображення стану команд
    private void displayTeamStatus(List<Droid> firstTeam, List<Droid> secondTeam) {
        System.out.println("\nСтан команд:");
        System.out.println("Команда 1:");
        for (Droid droid : firstTeam) {
            System.out.println(droid.getName() + " - Здоров'я: " + droid.getHealth());
        }
        System.out.println("Команда 2:");
        for (Droid droid : secondTeam) {
            System.out.println(droid.getName() + " - Здоров'я: " + droid.getHealth());
        }
        System.out.println("--------------------------\n");
    }


    private boolean startTeamFight(List<Droid> team1, List<Droid> team2) {
        while (true) {
            for (Droid attacker : team1) {
                if (team2.isEmpty()) {
                    return true; // Команда 1 перемогла
                }
                int targetIndex = new Random().nextInt(team2.size());
                Droid target = team2.get(targetIndex);

                attacker.attack(target);
                System.out.println(AnsiColors.RED + attacker.getName() + " атакує " + target.getName() + AnsiColors.RESET);
                battleLog.append(attacker.getName()).append(" атакував ").append(target.getName()).append(", залишилося ").append(target.getHealth()).append(" здоров'я.\n");

                if (target.getHealth() <= 0) {
                    System.out.println(AnsiColors.YELLOW + target.getName() + " загинув!" + AnsiColors.RESET);
                    battleLog.append(target.getName()).append(" загинув!\n");
                    team2.remove(targetIndex); // Видалити мертвого дроїда з команди
                }
            }

            for (Droid attacker : team2) {
                if (team1.isEmpty()) {
                    return false; // Команда 2 перемогла
                }
                int targetIndex = new Random().nextInt(team1.size());
                Droid target = team1.get(targetIndex);

                attacker.attack(target);
                System.out.println(AnsiColors.RED + attacker.getName() + " атакує " + target.getName() + AnsiColors.RESET);
                battleLog.append(attacker.getName()).append(" атакував ").append(target.getName()).append(", залишилося ").append(target.getHealth()).append(" здоров'я.\n");

                if (target.getHealth() <= 0) {
                    System.out.println(AnsiColors.YELLOW + target.getName() + " загинув!" + AnsiColors.RESET);
                    battleLog.append(target.getName()).append(" загинув!\n");
                    team1.remove(targetIndex); // Видалити мертвого дроїда з команди
                }
            }
        }
    }


    // Метод для запису результату бою у файл
    private void saveFightToFile() {
        System.out.print("Введіть ім'я файлу для збереження бою: ");
        String fileName = scanner.next();

        try (FileWriter writer = new FileWriter(fileName + ".txt")) {
            writer.write(battleLog.toString());
            System.out.println("Бій збережено у файл " + fileName + ".txt");
        } catch (IOException e) {
            System.out.println("Сталася помилка під час запису у файл.");
            e.printStackTrace();
        }
    }

    // Метод для завантаження бою з файлу
    private void loadFightFromFile() {
        System.out.print("Введіть ім'я файлу для завантаження бою: ");
        String fileName = scanner.next();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName + ".txt"))) {
            String line;
            System.out.println("Завантажений бій:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Сталася помилка під час завантаження файлу.");
            e.printStackTrace();
        }
    }
}
