package utng.data;

import org.hibernate.HibernateException;
import utng.model.Classm;



public class ClassmDAO extends DAO<Classm> {
     public ClassmDAO() {
        super(new Classm());
    }

    public Classm getOneById(Classm classm) throws HibernateException {
        return super.getOneById(classm.getIdClass()); 
    }
}