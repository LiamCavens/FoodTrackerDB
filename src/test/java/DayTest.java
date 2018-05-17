import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class DayTest {

    GregorianCalendar date;
    Day day;
    Food food;
    Food food2;
    Drink drink;
    Drink drink2;
    Meal meal;
    Meal meal2;

    @Before
    public void setUp() {
        day = new Day(date);
        meal = new Meal(MealType.LUNCH, day);
        meal2 = new Meal(MealType.DINNER, day);
        food = new Food("Chicken", 280, FoodType.POULTRY, meal);
        food2 = new Food("Chicken Enchiladas", 320, FoodType.POULTRY, meal2);
        drink = new Drink("Banana Milkshake", 450, DrinkType.MILK, meal);
        drink2 = new Drink("Top Posh Lyle Wine", 350, DrinkType.ALCOHOLIC, meal2);

        meal.addFood(food);
        meal.addDrink(drink);
        meal2.addFood(food2);
        meal2.addDrink(drink2);

        day.addMeal(meal);
        day.addMeal(meal2);
    }

    @Test
    public void dayHasMeals() {
        assertEquals(2, day.getMeals().size());
    }

    @Test
    public void canGetDayCalories() {
        assertEquals(1400, day.calculateDailyCalories());
    }
}
