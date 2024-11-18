package newyeargiftapp.commands;

import newyeargiftapp.gifts.Gift;
import newyeargiftapp.models.Candy;
import newyeargiftapp.models.Sweets;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SaveGiftCommandTest {

    private Gift gift;
    private SaveGiftCommand saveGiftCommand;

    @BeforeEach
    public void setUp() {
        // Створення об'єкта подарунка та додавання деяких солодощів
        gift = new Gift();
        gift.addSweet(new Candy(100, 50));  // додаємо солодощі
        saveGiftCommand = new SaveGiftCommand(gift);  // Створення команди для збереження
    }

    @AfterEach
    public void tearDown() {
        // Очищення файлу після тесту
        File file = new File("gift.txt");
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testSaveGiftCommandCreatesFile() {
        saveGiftCommand.execute();
        File file = new File("gift.txt");
        assertTrue(file.exists(), "Файл gift.txt має бути створений після виконання команди збереження.");
    }
}
