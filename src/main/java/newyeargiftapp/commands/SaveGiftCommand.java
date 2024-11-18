package newyeargiftapp.commands;

import newyeargiftapp.gifts.Gift;

public class SaveGiftCommand implements Command {
    private Gift gift;

    public SaveGiftCommand(Gift gift) {
        this.gift = gift;
    }

    @Override
    public void execute() {
        gift.saveToFile("gift.txt");
        System.out.println("Подарунок збережено у файл.");
    }
}