package hibernate

import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration

/**
 * Created by Junaid on 6/12/2016.
 */
class HibernateUtil {

    static final SessionFactory sessionFactory
    static {
        sessionFactory = new Configuration()
                .configure('/hibernate-pure.cfg.xml')
                .buildSessionFactory()
    }

    static void shutdown(){
        sessionFactory.close()
    }



}
