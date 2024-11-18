package newyeargiftapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class MainTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMainMenuAllOptions() {
        String simulatedInput =
                "1\n" + // Додати цукерку
                        "Цукерка\n100\n20\n" + // Назва, вага, вміст цукру
                        "2\n" + // Відсортувати солодощі
                        "3\n20\n" + // Знайти солодощі за вмістом цукру
                        "4\n" + // Вивести всі солодощі
                        "5\n1\n" + // Видалити солодощі
                        "6\n" + // Зберегти подарунок у файл
                        "7\n" + // Завантажити подарунок із файлу
                        "8\n"; // Вийти

        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        try {
            Main.main(new String[]{});
        } catch (Exception e) {
            fail("Main.main() threw an exception: " + e.getMessage());
        }

        String output = outContent.toString();
        assertTrue(output.contains("Додати солодощі до подарунку"));
        assertTrue(output.contains("Відсортувати солодощі за вагою"));
        assertTrue(output.contains("Знайти солодощі за вмістом цукру"));
        assertTrue(output.contains("Вивести всі солодощі"));
        assertTrue(output.contains("Видалити солодощі за списком"));
        assertTrue(output.contains("Зберегти подарунок у файл"));
        assertTrue(output.contains("Завантажити подарунок із файлу"));
        assertTrue(output.contains("Дякуємо за використання програми! Вихід."));
    }

    @Test
    public void testInvalidOptionHandling() {
        String simulatedInput =
                "10\n" + // Невірна опція
                        "abc\n" + // Нечесловий ввід
                        "8\n";   // Вийти

        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Main.main(new String[]{});

        String output = outContent.toString();
        assertTrue(output.contains("Невірна опція. Спробуйте ще раз."));
        assertTrue(output.contains("Будь ласка, введіть число."));
    }

    @Test
    public void testExitOption() {
        String simulatedInput = "8\n"; // Вийти

        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Main.main(new String[]{});

        String output = outContent.toString();
        assertTrue(output.contains("Дякуємо за використання програми! Вихід."));
    }

    @Test
    public void testInputOutsideRange() {
        String simulatedInput = "10\n8\n"; // Введено недопустиме значення, а потім допустиме (вихід)
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Main.main(new String[]{}); // Виклик програми

        String output = outContent.toString();
        assertTrue(output.contains("Невірна опція. Спробуйте ще раз.")); // Перевірка на правильний вихід
    }

}