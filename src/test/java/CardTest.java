import static org.junit.Assert.*;

public class CardTest {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void createAceCardFromStringInputTest() {
        String input = "DA";
        Card c = new Card(input);
        assertEquals(14, c.getRank());
        assertEquals(1, c.getSuit());
    }

    @org.junit.Test
    public void createCardFromStringInputTest() {
        String input = "S10";
        Card c = new Card(input);
        assertEquals(10, c.getRank());
        assertEquals(4, c.getSuit());
    }

    @org.junit.Test
    public void toStringTest() {
        Card c = new Card(2, 8);
        assertEquals("C8", c.toString());
    }

}