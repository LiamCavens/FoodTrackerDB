package models;

import javax.persistence.*;

@Entity
@Table(name="drinks")
public class Drink {

    private int id;
    private String name;
    private int calories;
    private DrinkType drinkType;
    private Meal meal;

    public Drink() {
    }

    public Drink(String name, int calories, DrinkType drinkType, Meal meal) {
        this.name = name;
        this.calories = calories;
        this.drinkType = drinkType;
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

    @Column(name="drink_type")
    public DrinkType getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(DrinkType drinkType) {
        this.drinkType = drinkType;
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
