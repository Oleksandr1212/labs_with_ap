package newyeargiftapp.commands;

import newyeargiftapp.gifts.Gift;

public class DisplaySweetsCommand implements Command {
    private Gift gift;

    public DisplaySweetsCommand(Gift gift) {
        this.gift = gift;
    }

    @Override
    public void execute() {
        gift.displaySweets();
    }
}