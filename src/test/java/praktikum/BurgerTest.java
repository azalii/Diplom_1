package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Burger;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class BurgerTest {
    Burger burger;

    @Before
    public void setup() {
        Bun bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getName()).thenReturn("bunName");
        Mockito.when(bun.getPrice()).thenReturn(9.99f);

        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient.getName()).thenReturn("ingredientName1");
        Mockito.when(ingredient.getPrice()).thenReturn(1.00f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);

        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient2.getName()).thenReturn("ingredientName2");
        Mockito.when(ingredient2.getPrice()).thenReturn(2.00f);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);

        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
    }

    @Test
    public void getPriceTest() {
        assertEquals(22.98f, burger.getPrice(), 0.0f);
    }

    @Test
    public void getReceiptTest() {
        StringBuilder result = new StringBuilder();
        result.append("(==== bunName ====)").append("\n");
        result.append("= sauce ingredientName1 =").append("\n");
        result.append("= filling ingredientName2 =").append("\n");
        result.append("(==== bunName ====)").append("\n");
        result.append("\n");
        result.append("Price: 22.980000").append("\n");

        assertEquals(result.toString(), burger.getReceipt());
    }

    @Test
    public void moveIngredientTest() {
        burger.moveIngredient(1, 0);
        assertEquals("ingredientName2", burger.ingredients.get(0).getName());
    }

    @Test
    public void removeIngredientTest() {
        burger.removeIngredient(1);
        assertEquals(1, burger.ingredients.size());
    }
}
