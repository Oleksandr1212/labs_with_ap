package newyeargiftapp.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CandyTest {
    @Test
    void testCandyCreation() {
        Candy candy = new Candy(100, 20);
        assertEquals(100, candy.getWeight());
        assertEquals(20, candy.getSugarContent());
    }
}
