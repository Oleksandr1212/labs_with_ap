package newyeargiftapp.commands;

import newyeargiftapp.gifts.Gift;
import java.util.Scanner;

public class RemoveSweetCommand implements Command {
    private Gift gift;

    public RemoveSweetCommand(Gift gift) {
        this.gift = gift;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть індекс солодощів для видалення: ");
        int index = scanner.nextInt()-1;

        gift.removeSweet(index);
        System.out.println("Солодощі видалено.");
    }
}