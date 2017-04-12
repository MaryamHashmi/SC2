package lab06;

import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GreatCircle implements IntDistance{
    double tt;
    @Override
    public double distance(double lat1, double lng1, double lat2, double lng2)
    {
        double pk = (double) (180/Math.PI);
        double B1 = lat1 / pk;
        double B2 = lat2 / pk;
        double dL = (lng1-lng2) / pk;

        double t1 = (double) (Math.cos(B1)*Math.cos(B2)*Math.cos(dL));
        double t2 = (double) (Math.sin(B1)*Math.sin(B2));

        tt = (double) Math.acos(t1 + t2);
        return tt;
    }
    
}

