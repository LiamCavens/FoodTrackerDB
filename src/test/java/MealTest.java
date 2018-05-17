import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class MealTest {

    GregorianCalendar date;
    Day day;
    Food food;
    Food food2;
    Drink drink;
    Drink drink2;
    Meal meal;

    @Before
    public void setUp() {
        day = new Day(date);
        meal = new Meal(MealType.LUNCH, day);
        food = new Food("Chicken", 280, FoodType.POULTRY, meal);
        food2 = new Food("Chicken Enchiladas", 320, FoodType.POULTRY, meal);
        drink = new Drink("Banana Milkshake", 450, DrinkType.MILK, meal);
        drink2 = new Drink("Top Posh Lyle Wine", 350, DrinkType.ALCOHOLIC, meal);

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

    @Test
    public void foodHasCalories() {
        assertEquals(280, food.getCalories());
    }

    @Test
    public void drinkHasCalories() {
        assertEquals(450, drink.getCalories());
    }

    @Test
    public void getTotalFoodCalories() {
        meal.addFood(food);
        meal.addFood(food2);
        assertEquals(600, meal.calculateCaloriesFromFoods());
    }

    @Test
    public void getTotalDrinkCalories() {
        meal.addDrink(drink);
        meal.addDrink(drink2);
        assertEquals(800, meal.calculateCaloriesFromDrinks());
    }

    @Test
    public void totalMealCalories() {
        meal.addFood(food);
        meal.addDrink(drink);
        assertEquals(730, meal.calculateTotalCalories());
    }
}
