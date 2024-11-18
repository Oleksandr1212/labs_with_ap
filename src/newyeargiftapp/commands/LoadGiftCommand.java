package newyeargiftapp.commands;

import newyeargiftapp.gifts.Gift;

public class LoadGiftCommand implements Command {
    private Gift gift;

    public LoadGiftCommand(Gift gift) {
        this.gift = gift;
    }

    @Override
    public void execute() {
        gift.loadFromFile("gift.txt");
        System.out.println("Подарунок завантажено з файлу.");
    }
}