package newyeargiftapp.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CookieTest {

    @Test
    void testCookieConstructor() {
        double weight = 150.0;
        double sugarContent = 25.0;

        Cookie cookie = new Cookie(weight, sugarContent);

        assertEquals(weight, cookie.getWeight());
        assertEquals(sugarContent, cookie.getSugarContent());
    }

    @Test
    void testToString() {
        Cookie cookie = new Cookie(150.0, 25.0);
        String expectedOutput = "Печиво: вага = 150.0, вміст цукру = 25.0";

        assertEquals(expectedOutput, cookie.toString());
    }
}
