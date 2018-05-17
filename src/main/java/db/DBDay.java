package db;

import models.Day;
import models.Food;
import models.Meal;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBDay {

    private static Session session;

    public static List<Meal> getMealFromDay(Day day) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Meal> results = null;
        try {
            Criteria criteria = session.createCriteria(Meal.class);
            criteria.add(Restrictions.eq("day", day));
            results = criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
