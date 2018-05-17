package models;

import javax.persistence.*;

public class Food {

    private int id;
    private String name;
    private int calories;
    private FoodType foodType;
    private Meal meal;

    public Food() {
    }

    public Food(String name, int calories, FoodType foodType, Meal meal) {
        this.name = name;
        this.calories = calories;
        this.foodType = foodType;
        this.meal = meal;
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

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="calories")
    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Column(name="food_type")
    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    @ManyToOne
    @JoinColumn(name="meal_id", nullable = false)
    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}
