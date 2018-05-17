import db.DBHelper;
import models.*;

import java.util.GregorianCalendar;

public class Runner {

    public static void main(String[] args) {

        GregorianCalendar date1 = new GregorianCalendar(2018, 4, 1);

        Day day1 = new Day(date1);

        Meal breakfast1 = new Meal(MealType.BREAKFAST, day1);
        Meal lunch1 = new Meal(MealType.LUNCH, day1);
        Meal dinner1 = new Meal(MealType.DINNER, day1);
        Meal snack1 = new Meal(MealType.SNACK, day1);

        Food cereal = new Food("Cinnamon Things", 420, FoodType.CARBS, breakfast1);
        Food chicken = new Food("Chicken", 250, FoodType.POULTRY, lunch1);
        Food steak = new Food("Sirloin", 500, FoodType.MEAT, dinner1);
        Food chocolate = new Food ("Kinder", 430, FoodType.SWEET, snack1);

        Drink water1 = new Drink("Cooncil Juice", 0, DrinkType.STILL, breakfast1);
        Drink water2 = new Drink("Cooncil Juice", 0, DrinkType.STILL, lunch1);
        Drink water3 = new Drink("Cooncil Juice", 0, DrinkType.STILL, dinner1);
        Drink water4 = new Drink("Cooncil Juice", 0, DrinkType.STILL, snack1);

        DBHelper.saveOrUpdate(day1);
        DBHelper.saveOrUpdate(breakfast1);
        DBHelper.saveOrUpdate(lunch1);
        DBHelper.saveOrUpdate(dinner1);
        DBHelper.saveOrUpdate(snack1);
        DBHelper.saveOrUpdate(cereal);
        DBHelper.saveOrUpdate(chicken);
        DBHelper.saveOrUpdate(steak);
        DBHelper.saveOrUpdate(chocolate);
        DBHelper.saveOrUpdate(water1);
        DBHelper.saveOrUpdate(water2);
        DBHelper.saveOrUpdate(water3);
        DBHelper.saveOrUpdate(water4);
    }
}
