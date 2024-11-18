package newyeargiftapp.commands;

import newyeargiftapp.commands.LoadGiftCommand;
import newyeargiftapp.gifts.Gift;
import newyeargiftapp.models.Candy;
import newyeargiftapp.models.Chocolate;
import newyeargiftapp.models.Cookie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class LoadGiftCommandTest {
    private static final String TEST_FILE_NAME = "test_gift.txt";
    private Gift originalGift;

    @BeforeEach
    public void setUp() {
        originalGift = new Gift();
        originalGift.addSweet(new Candy(100.0, 20.0));
        originalGift.addSweet(new Chocolate(200.0, 30.0));
        originalGift.addSweet(new Cookie(50.0, 10.0));

        // Зберігаємо оригінальний подарунок у файл
        originalGift.saveToFile(TEST_FILE_NAME);
    }

    @AfterEach
    public void tearDown() {
        File file = new File(TEST_FILE_NAME);
        if (file.exists()) {
            file.delete();
        }
    }
    @Test
    public void testExecute() {
        // Створюємо новий об'єкт Gift
        Gift gift = new Gift();

        // Перед тим, як виконати команду, записуємо тестові дані в файл gift.txt
        gift.addSweet(new Candy(100.0, 20.0));
        gift.addSweet(new Chocolate(200.0, 30.0));
        gift.addSweet(new Cookie(50.0, 10.0));

        // Зберігаємо подарунок у файл
        gift.saveToFile("gift.txt");

        // Створюємо команду для завантаження подарунка
        LoadGiftCommand loadGiftCommand = new LoadGiftCommand(gift);

        // Виконуємо команду завантаження
        loadGiftCommand.execute();

        // Перевіряємо, що подарунок більше не порожній після завантаження
        assertFalse(gift.isEmpty(), "Подарунок не повинен бути порожнім після завантаження");

        // Перевіряємо кількість солодощів в подарунку
        assertEquals(3, gift.getSweetsList().size(), "Має бути 3 солодощі в подарунку");
    }

}

