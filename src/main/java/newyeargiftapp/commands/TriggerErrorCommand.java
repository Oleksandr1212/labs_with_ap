package newyeargiftapp.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriggerErrorCommand implements Command {
    private static final Logger logger = LogManager.getLogger(TriggerErrorCommand.class);

    @Override
    public void execute() {
        int sum = 12;
        try {
            sum = sum / 0; // Викликаємо помилку ділення на нуль
        } catch (ArithmeticException e) {
            logger.error("Сталася критична помилка: " + e.getMessage(), e);
            System.out.println("Сталася критична помилка: " + e.getMessage());
        }
    }
}
