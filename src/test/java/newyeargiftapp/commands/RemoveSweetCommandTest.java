package newyeargiftapp.commands;

import newyeargiftapp.commands.RemoveSweetCommand;
import newyeargiftapp.gifts.Gift;
import newyeargiftapp.models.Chocolate;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveSweetCommandTest {

    @Test
    public void testRemoveSweet() {
        Gift gift = new Gift();
        gift.addSweet(new Chocolate(150.0, 10.0));
        gift.addSweet(new Chocolate(200.0, 20.0));

        RemoveSweetCommand command = new RemoveSweetCommand(gift);

        // Імітуємо введення користувача: 1 (перший елемент)
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        command.execute();

        assertEquals(1, gift.getSweetsList().size());
    }
}
