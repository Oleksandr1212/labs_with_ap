package newyeargiftapp.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChocolateTest {
    @Test
    void testChocolateCreation() {
        Chocolate chocolate = new Chocolate(150, 25);
        assertEquals(150, chocolate.getWeight());
        assertEquals(25, chocolate.getSugarContent());
    }
}
