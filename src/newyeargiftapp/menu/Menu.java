package newyeargiftapp.menu;

import newyeargiftapp.commands.Command;

public class Menu {
    private Command[] commands = new Command[8]; // Враховано 8 опцій меню

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