package newyeargiftapp.menu;

import newyeargiftapp.commands.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

class MenuTest {
    private Menu menu;
    private Command mockCommand;

    @BeforeEach
    void setUp() {
        menu = new Menu();
        mockCommand = Mockito.mock(Command.class);
    }

    @Test
    void testSetAndExecuteCommand() {
        // Встановлюємо команду на певній позиції
        menu.setCommand(0, mockCommand);
        // Виконуємо команду
        menu.selectOption(0);

        // Перевіряємо, що команда виконується
        verify(mockCommand, times(1)).execute();
    }

    @Test
    void testExecuteCommandNotFound() {
        // Перевіряємо, що спроба виконати відсутню команду не викликає помилок
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> menu.selectOption(10));
    }

    @Test
    void testExecuteNullCommand() {
        // Перевіряємо, що виклик відсутньої команди не викликає помилок
        menu.selectOption(1); // Немає команди на цій позиції
    }
}
