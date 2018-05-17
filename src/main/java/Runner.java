import db.DBDay;
import db.DBHelper;
import db.DBMeal;
import models.*;

import java.util.GregorianCalendar;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        GregorianCalendar date1 = new GregorianCalendar(2018, 4, 1);
        GregorianCalendar date2 = new GregorianCalendar(2018, 4, 2);

        Day day1 = new Day(date1);
        Day day2 = new Day(date2);

        Meal breakfast1 = new Meal(MealType.BREAKFAST, day1);
        Meal lunch1 = new Meal(MealType.LUNCH, day1);
        Meal dinner1 = new Meal(MealType.DINNER, day1);
        Meal snack1 = new Meal(MealType.SNACK, day1);
        Meal snack2 = new Meal(MealType.SNACK, day2);

        Food cereal = new Food("Cinnamon Things", 420, FoodType.CARBS, breakfast1);
        Food cereal2 = new Food("Cinnamon Things", 420, FoodType.CARBS, breakfast1);
        Food chicken = new Food("Chicken", 250, FoodType.POULTRY, lunch1);
        Food steak = new Food("Sirloin", 500, FoodType.MEAT, dinner1);
        Food chocolate = new Food("Kinder", 430, FoodType.SWEET, snack1);
        Food chocolate2 = new Food("Kinder", 430, FoodType.SWEET, snack2);

        Drink water1 = new Drink("Cooncil Juice", 0, DrinkType.STILL, breakfast1);
        Drink water2 = new Drink("Cooncil Juice", 0, DrinkType.STILL, lunch1);
        Drink water3 = new Drink("Cooncil Juice", 0, DrinkType.STILL, dinner1);
        Drink water4 = new Drink("Cooncil Juice", 0, DrinkType.STILL, snack1);

        DBHelper.saveOrUpdate(day1);
        DBHelper.saveOrUpdate(day2);
        DBHelper.saveOrUpdate(breakfast1);
        DBHelper.saveOrUpdate(lunch1);
        DBHelper.saveOrUpdate(dinner1);
        DBHelper.saveOrUpdate(snack1);
        DBHelper.saveOrUpdate(cereal);
        DBHelper.saveOrUpdate(cereal2);
        DBHelper.saveOrUpdate(chicken);
        DBHelper.saveOrUpdate(steak);
        DBHelper.saveOrUpdate(chocolate);
        DBHelper.saveOrUpdate(chocolate2);
        DBHelper.saveOrUpdate(water1);
        DBHelper.saveOrUpdate(water2);
        DBHelper.saveOrUpdate(water3);
        DBHelper.saveOrUpdate(water4);

        List<Food> foodInMeal = DBMeal.getFoodFromMeal(breakfast1);

        List<Meal> mealsInDay = DBDay.getMealFromDay(day1);

    }
}
