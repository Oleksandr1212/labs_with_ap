package newyeargiftapp.commands;

import newyeargiftapp.gifts.Gift;
import java.util.Scanner;

public class FindSweetCommand implements Command {
    private Gift gift;

    public FindSweetCommand(Gift gift) {
        this.gift = gift;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть вміст цукру для пошуку: ");
        double sugarContent = scanner.nextDouble();

        gift.findSweetBySugar(sugarContent);
    }
}