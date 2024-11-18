package newyeargiftapp.gifts;

import newyeargiftapp.models.Candy;
import newyeargiftapp.models.Chocolate;
import newyeargiftapp.models.Cookie;
import newyeargiftapp.models.Sweets;
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GiftTest {
    private Gift gift;
    private final String testFile = "testGift.txt";

    @BeforeEach
    void setUp() {
        gift = new Gift();
    }

    @AfterEach
    void tearDown() {
        File file = new File(testFile);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testIsEmptyWhenListIsEmpty() {
        assertTrue(gift.isEmpty(), "The gift should be empty.");
    }

    @Test
    void testIsEmptyWhenListIsNotEmpty() {
        gift.addSweet(new Candy(100, 20));
        assertFalse(gift.isEmpty(), "The gift should not be empty.");
    }

    @Test
    void testAddSweet() {
        Sweets candy = new Candy(100, 20);
        gift.addSweet(candy);
        assertEquals(1, gift.getSweetsList().size());
        assertEquals(candy, gift.getSweetsList().get(0));
    }

    @Test
    void testRemoveSweetWithValidIndex() {
        Sweets candy = new Candy(100, 20);
        gift.addSweet(candy);
        gift.removeSweet(0);
        assertTrue(gift.getSweetsList().isEmpty());
    }

    @Test
    void testRemoveSweetWithInvalidIndex() {
        Sweets candy = new Candy(100, 20);
        gift.addSweet(candy);
        gift.removeSweet(-1); // Invalid index
        gift.removeSweet(10); // Invalid index
        assertEquals(1, gift.getSweetsList().size()); // List should remain unchanged
    }

    @Test
    void testDisplaySweetsWhenEmpty() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        gift.displaySweets();
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Список солодощів порожній."), "Expected a message indicating that the sweets list is empty.");
    }


    @Test
    void testSortSweets() {
        Sweets candy = new Candy(200, 20);
        Sweets chocolate = new Chocolate(100, 30);
        gift.addSweet(candy);
        gift.addSweet(chocolate);
        gift.sortSweets();
        List<Sweets> sortedList = gift.getSweetsList();
        assertEquals(chocolate, sortedList.get(0));
        assertEquals(candy, sortedList.get(1));
    }

    @Test
    void testDisplaySweetsWithItems() {
        Sweets candy = new Candy(100, 20);
        gift.addSweet(candy);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        gift.displaySweets();
        assertTrue(outputStream.toString().contains("Candy"), "Expected 'Candy' to be displayed.");
    }

    @Test
    void testFindSweetBySugarWithMatch() {
        Sweets candy = new Candy(100, 20);
        Sweets chocolate = new Chocolate(200, 30);
        gift.addSweet(candy);
        gift.addSweet(chocolate);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        gift.findSweetBySugar(30);
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Chocolate"), "Expected 'Chocolate' to be found by sugar content.");
    }

    @Test
    void testFindSweetBySugarWithoutMatch() {
        Sweets candy = new Candy(100, 20);
        gift.addSweet(candy);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        gift.findSweetBySugar(50); // No matching sugar content
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Солодощі з вмістом цукру 50.0 не знайдено."),
                "Expected a message indicating that no sweets with sugar content of 50.0 were found.");
    }


    @Test
    void testSaveToFile() throws IOException {
        Sweets candy = new Candy(100, 20);
        Sweets chocolate = new Chocolate(200, 30);
        gift.addSweet(candy);
        gift.addSweet(chocolate);

        gift.saveToFile(testFile);

        BufferedReader reader = new BufferedReader(new FileReader(testFile));
        String line = reader.readLine();
        assertNotNull(line, "The first line in the file should not be null.");
        assertTrue(line.contains("Candy"), "The first line should contain 'Candy'.");
        reader.close();
    }

    @Test
    void testLoadFromFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(testFile));
        writer.write("Candy,100,20\n");
        writer.write("Chocolate,200,30\n");
        writer.write("Cookie,150,25\n");
        writer.close();

        gift.loadFromFile(testFile);

        List<Sweets> sweetsList = gift.getSweetsList();
        assertEquals(3, sweetsList.size(), "Expected to load 3 sweets from the file.");
        assertTrue(sweetsList.get(0) instanceof Candy, "The first sweet should be a Candy.");
        assertTrue(sweetsList.get(1) instanceof Chocolate, "The second sweet should be a Chocolate.");
        assertTrue(sweetsList.get(2) instanceof Cookie, "The third sweet should be a Cookie.");
    }

    @Test
    void testLoadFromFileWithUnknownType() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(testFile));
        writer.write("UnknownSweet,100,20\n");
        writer.close();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        gift.loadFromFile(testFile);

        assertTrue(outputStream.toString().contains("Невідомий тип солодощів"), "Expected a message about unknown sweets type.");
    }

    @Test
    void testLoadFromFileFileNotFound() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        gift.loadFromFile("nonexistentFile.txt");
        assertTrue(outputStream.toString().contains("Файл не знайдено"), "Expected a message indicating that the file was not found.");
    }
}
