package db;

import models.Drink;
import models.Food;
import models.Meal;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBMeal {

    private static Session session;

    public static List<Food> getFoodFromMeal(Meal meal) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Food> results = null;
        try {
            Criteria criteria = session.createCriteria(Food.class);
            criteria.add(Restrictions.eq("meal", meal));
            results = criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static List<Drink> getDrinkFromMeal(Meal meal) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Drink> results = null;
        try {
            Criteria criteria = session.createCriteria(Drink.class);
            criteria.add(Restrictions.eq("meal", meal));
            results = criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
