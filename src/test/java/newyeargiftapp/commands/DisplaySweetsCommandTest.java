package newyeargiftapp.commands;

import newyeargiftapp.gifts.Gift;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class DisplaySweetsCommandTest {
    private Gift mockGift;
    private DisplaySweetsCommand command;

    @BeforeEach
    void setUp() {
        // Створення мок-об'єкта класу Gift
        mockGift = Mockito.mock(Gift.class);
        // Ініціалізація команди з мок-об'єктом
        command = new DisplaySweetsCommand(mockGift);
    }

    @Test
    void testExecuteCallsDisplaySweets() {
        // Виконання команди
        command.execute();
        // Перевірка, що метод displaySweets був викликаний
        verify(mockGift).displaySweets();
    }

    @Test
    void testExecuteMultipleCalls() {
        // Виконання команди декілька разів
        command.execute();
        command.execute();
        // Перевірка, що метод displaySweets був викликаний два рази
        verify(mockGift, times(2)).displaySweets();
    }

    @Test
    void testExecuteWithDifferentGiftStates() {
        // Налаштування поведінки для мок-об'єкта, якщо в нього немає солодощів
        when(mockGift.hasSweets()).thenReturn(true);
        command.execute();
        verify(mockGift).displaySweets();

        // Зміна стану Gift для тестування без солодощів
        when(mockGift.hasSweets()).thenReturn(false);
        command.execute();
        verify(mockGift, times(2)).displaySweets();
    }



}