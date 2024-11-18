package newyeargiftapp.commands;

import newyeargiftapp.gifts.Gift;
import newyeargiftapp.models.Sweets;
import newyeargiftapp.models.Candy;
import newyeargiftapp.models.Chocolate;
import newyeargiftapp.models.Cookie;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddSweetCommandTest {

    @Test
    public void testAddCandy() {
        Gift gift = new Gift();
        AddSweetCommand command = new AddSweetCommand(gift);

        String input = "1\n100.5\n20.0\n"; // Цукерка
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        command.execute();

        List<Sweets> sweetsList = gift.getSweetsList();
        assertEquals(1, sweetsList.size());
        assertEquals(100.5, sweetsList.get(0).getWeight());
        assertEquals(20.0, sweetsList.get(0).getSugarContent());
    }

    @Test
    public void testAddChocolate() {
        Gift gift = new Gift();
        AddSweetCommand command = new AddSweetCommand(gift);

        String input = "2\n150.0\n25.0\n"; // Шоколад
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        command.execute();

        List<Sweets> sweetsList = gift.getSweetsList();
        assertEquals(1, sweetsList.size());
        assertEquals(150.0, sweetsList.get(0).getWeight());
        assertEquals(25.0, sweetsList.get(0).getSugarContent());
    }

    @Test
    public void testAddCookie() {
        Gift gift = new Gift();
        AddSweetCommand command = new AddSweetCommand(gift);

        String input = "3\n50.0\n10.0\n"; // Печиво
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        command.execute();

        List<Sweets> sweetsList = gift.getSweetsList();
        assertEquals(1, sweetsList.size());
        assertEquals(50.0, sweetsList.get(0).getWeight());
        assertEquals(10.0, sweetsList.get(0).getSugarContent());
    }

    @Test
    public void testAddInvalidType() {
        Gift gift = new Gift();
        AddSweetCommand command = new AddSweetCommand(gift);

        String input = "4\n100.0\n20.0\n"; // Неправильний тип
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        command.execute();

        List<Sweets> sweetsList = gift.getSweetsList();
        assertEquals(0, sweetsList.size());
    }

    @Test
    public void testAddInvalidWeight() {
        Gift gift = new Gift();
        AddSweetCommand command = new AddSweetCommand(gift);

        String input = "1\ninvalid\n20.0\n"; // Неправильна вага
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        command.execute();

        List<Sweets> sweetsList = gift.getSweetsList();
        assertEquals(0, sweetsList.size());
    }

    @Test
    public void testAddInvalidSugarContent() {
        Gift gift = new Gift();
        AddSweetCommand command = new AddSweetCommand(gift);

        String input = "1\n100.0\ninvalid\n"; // Неправильний вміст цукру
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        command.execute();

        List<Sweets> sweetsList = gift.getSweetsList();
        assertEquals(0, sweetsList.size());
    }
}
