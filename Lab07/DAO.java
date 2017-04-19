/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mika
 */
import java.util.ArrayList;
import model.data;
import org.hibernate.Session;
import org.hibernate.Transaction; 
import util.HibernateUtil;

public class DAO {
public Session currSession = null; public DAO(){
HibernateUtil.createSessionFactory();
currSession=HibernateUtil.getSessionFactory().openSession(); }

public void finalize(){ 
    currSession.close();
}

public void save(ArrayList<Employee> newEmpList){ Transaction t=currSession.beginTransaction();
for(int i=0;i<newEmpList.size();i++){ currSession.persist((Employee)newEmpList.get(i));
}
t.commit();
}

public void printEmployees(){
Query query=currSession.createQuery("from Employee");
List<Employee> list=query.list(); HQL
Iterator<Employee> itr=list.iterator(); while(itr .hasNext()){
Employee emp=itr.next();
System.out.println("Emp Name: "+emp.getFirstName()); }
} 
}