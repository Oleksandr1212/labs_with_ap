package newyeargiftapp.commands;

import newyeargiftapp.gifts.Gift;

public class SortSweetsCommand implements Command {
    private Gift gift;

    public SortSweetsCommand(Gift gift) {
        this.gift = gift;
    }

    @Override
    public void execute() {
        gift.sortSweets();
        System.out.println("Солодощі відсортовано за вагою.");
    }
}