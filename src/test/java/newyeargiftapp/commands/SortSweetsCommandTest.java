package newyeargiftapp.commands;

import newyeargiftapp.commands.SortSweetsCommand;
import newyeargiftapp.gifts.Gift;
import newyeargiftapp.models.Candy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortSweetsCommandTest {

    @Test
    public void testSortSweets() {
        Gift gift = new Gift();
        gift.addSweet(new Candy(200.0, 30.0));
        gift.addSweet(new Candy(100.0, 20.0));
        gift.addSweet(new Candy(150.0, 25.0));

        SortSweetsCommand command = new SortSweetsCommand(gift);
        command.execute();

        assertTrue(gift.getSweetsList().get(0).getWeight() <= gift.getSweetsList().get(1).getWeight());
        assertTrue(gift.getSweetsList().get(1).getWeight() <= gift.getSweetsList().get(2).getWeight());
    }
}
