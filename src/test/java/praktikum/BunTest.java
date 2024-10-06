package praktikum;

import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun;

    @Before
    public void setup() {
        bun = new Bun("testName", 9.99F);
    }

    @Test
    public void getNameTest() {
        assertEquals("testName", bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(9.99F, bun.getPrice(), 0.0f);
    }
}
