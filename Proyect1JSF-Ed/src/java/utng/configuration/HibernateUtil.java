package utng.configuration;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private static Session session;
    static{
        try {
            sessionFactory= new AnnotationConfiguration().configure("/utng/"
            +"configuration/hibernate.cfg.xml").buildSessionFactory();
            session=sessionFactory.openSession();
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError(
            "Error to Start"+"SessionFactory"+e);
        }
    
    }

    public static Session getSession() {
        return session;
    }
    
    @Override
    protected void finalize()throws Throwable{
        session.close();
        session=null;
    }
    public static void main(String[] args) {
        new HibernateUtil().getSession();
    }
}
