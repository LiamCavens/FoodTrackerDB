import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class MealTest {

    GregorianCalendar date;
    Day day;
    Food food;
    Drink drink;
    Meal meal;

    @Before
    public void setUp() {
        day = new Day(date);
        meal = new Meal(MealType.LUNCH, day);
        food = new Food("Chicken", 280, FoodType.POULTRY, meal);
        drink = new Drink("Banana Milkshake", 450, DrinkType.MILK, meal);

    }

    @Test
    public void hasFoodInMeal() {
        meal.addFood(food);
        assertEquals(1, meal.getFood().size());
    }

    @Test
    public void hasDrinkInMeal() {
        meal.addDrink(drink);
        assertEquals(1, meal.getDrinks().size());
    }
}
