package newyeargiftapp.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SweetsTest {

    // Створення підкласу для тестування абстрактного класу Sweets
    static class TestSweet extends Sweets {
        public TestSweet(double weight, double sugarContent) {
            super(weight, sugarContent);
        }
    }

    @Test
    void testConstructor() {
        double weight = 200.0;
        double sugarContent = 30.0;

        Sweets sweet = new TestSweet(weight, sugarContent);

        assertEquals(weight, sweet.getWeight());
        assertEquals(sugarContent, sweet.getSugarContent());
    }

    @Test
    void testToString() {
        Sweets sweet = new TestSweet(200.0, 30.0);
        String expectedOutput = "Солодощі: вага = 200.0, вміст цукру = 30.0";

        assertEquals(expectedOutput, sweet.toString());
    }
}
