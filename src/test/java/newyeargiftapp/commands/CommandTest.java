package newyeargiftapp.commands;

import newyeargiftapp.commands.Command;
import newyeargiftapp.commands.LoadGiftCommand;
import newyeargiftapp.gifts.Gift;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CommandTest {
    @Test
    public void testLoadGiftCommand() {
        Gift gift = new Gift();

        Command loadGiftCommand = new LoadGiftCommand(gift);
        loadGiftCommand.execute();
        assertNotNull(gift, "Об'єкт Gift не повинен бути null після виконання команди");
    }
}
