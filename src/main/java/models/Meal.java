package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="meals")
public class Meal {

    private int id;
    private MealType mealType;
    private Set<Food> food;
    private Set<Drink> drinks;
    private Day day;

    public Meal() {
    }

    public Meal(MealType mealType, Day day) {
        this.mealType = mealType;
        this.food = new HashSet<Food>();
        this.drinks = new HashSet<Drink>();
        this.day = day;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="meal_type")
    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    @OneToMany(mappedBy = "meal")
    public Set<Food> getFood() {
        return food;
    }

    public void setFood(Set<Food> food) {
        this.food = food;
    }

    public void addFood(Food food){
        this.food.add(food);
    }

    @OneToMany(mappedBy = "meal")
    public Set<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(Set<Drink> drinks) {
        this.drinks = drinks;
    }

    public void addDrink(Drink drink){
        this.drinks.add(drink);
    }

    @ManyToOne
    @JoinColumn(name="day_id", nullable = false)
    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public int calculateCaloriesFromFoods(){
        int result = 0;
        for(Food food : this.food){
            result += food.getCalories();
        }
        return result;
    }

    public int calculateCaloriesFromDrinks(){
        int result = 0;
        for(Drink drink : this.drinks){
            result += drink.getCalories();
        }
        return result;
    }

    public int calculateTotalCalories(){
        return calculateCaloriesFromDrinks() + calculateCaloriesFromFoods();
    }
}
