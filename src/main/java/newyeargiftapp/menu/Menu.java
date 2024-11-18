package newyeargiftapp.menu;

import newyeargiftapp.commands.Command;

public class Menu {
    private Command[] commands = new Command[9]; // Змінили розмір масиву на 9

    public void setCommand(int index, Command command) {
        commands[index] = command;
    }

    public void selectOption(int index) {
        if (commands[index] != null) {
            commands[index].execute();
        } else {
            System.out.println("Команда не знайдена.");
        }
    }
}
