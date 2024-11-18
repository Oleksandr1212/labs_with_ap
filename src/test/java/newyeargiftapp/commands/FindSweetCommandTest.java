package newyeargiftapp.commands;

import newyeargiftapp.gifts.Gift;
import newyeargiftapp.models.Cookie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Locale;

public class FindSweetCommandTest {
    private final InputStream systemIn = System.in;

    @BeforeEach
    public void setUp() {
        // Встановлюємо локаль для розпізнавання крапки у числах
        Locale.setDefault(Locale.US);
    }

    @AfterEach
    public void restoreSystemIn() {
        // Повертаємо стандартний вхідний потік після тесту
        System.setIn(systemIn);
    }

    @Test
    public void testFindSweetBySugar() {
        Gift gift = new Gift();
        gift.addSweet(new Cookie(100.0, 15.0));
        gift.addSweet(new Cookie(120.0, 25.0));

        FindSweetCommand command = new FindSweetCommand(gift);

        // Імітуємо введення користувача: 25.0 (вміст цукру)
        String input = "25.0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        command.execute();

        // Перевірка результатів (у реальних випадках можна було б використати захоплення виводу або змінити метод для повернення результату).
    }
}
