package praktikum;

import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void isSauceType() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void isFillingType() {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}
