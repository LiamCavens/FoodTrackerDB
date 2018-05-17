package models;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="days")
public class Day {

    private int id;
    private GregorianCalendar date;
    private Set<Meal> meals;

    public Day() {
    }

    public Day(GregorianCalendar date) {
        this.date = date;
        this.meals = new HashSet<Meal>();
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

    @Column(name="date")
    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    @OneToMany(mappedBy = "day")
    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }

    public void addMeal(Meal meal){
        this.meals.add(meal);
    }

    public int calculateDailyCalories(){
        int result = 0;
        for(Meal meal : meals){
            result += meal.calculateTotalCalories();
        }
        return result;
    }

   // public List<Food>
}
