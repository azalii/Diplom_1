package praktikum;

import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private Ingredient ingredient;
    private final IngredientType type;
    private final String name;
    private final Float price;

    public IngredientTest(IngredientType type, String name, Float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "ингредиент с типом {0}")
    public static Object[][] getParameters() {
        return new Object[][]{
                {IngredientType.SAUCE, "testName1", 9.99F},
                {IngredientType.FILLING, "testName2", 4.99F},
        };
    }

    @Before
    public void setup() {
        ingredient = new Ingredient(type, name,  price);
    }

    @Test
    public void getNameTest() {
        assertEquals(this.name, ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(this.price, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void getTypeTest() {
        assertEquals(this.type, ingredient.getType());
    }
}
