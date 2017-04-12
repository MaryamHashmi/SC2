package lab06;

import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
public interface IntDistance {
     /**
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return
     */
    abstract double distance(double lat1, double lng1, double lat2, double lng2);
}
