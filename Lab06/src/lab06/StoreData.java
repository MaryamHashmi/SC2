package lab06;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;import java.io.File;
 import java.io.FileNotFoundException;
import java.io.FileReader;
 import java.util.Scanner;
 import java.util.logging.Level;
 import java.util.logging.Logger;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;  
import org.hibernate.service.ServiceRegistry;
import org.hibernate.criterion.Restrictions;
import java.io.IOException;
import javax.persistence.*;
import java.util.List;
import java.util.Iterator;
import org.hibernate.HibernateException;



public class StoreData implements IntNum {
     public static int count;
    
  
    @Override
    public void store() {
            Connect.connect();
        
            Configuration cfg=new Configuration();  
            cfg.configure("orm/hibernate.cfg.xml");//populates the data of the configuration file  
		//creating seession factory object  
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()). build();
            SessionFactory factory=cfg.buildSessionFactory(serviceRegistry);
		
            String line;
            String csv="/Users/test1/Downloads/Lab06/glc.csv";
            try(BufferedReader br = new BufferedReader(new FileReader(csv))) {
            
                count=0;
                Records e1=new Records();  

                while((line = br.readLine()) != null)
                {
                    if(count>1){
                                Session session=factory.openSession();  
                               // creating transaction object  
                                Transaction t=session.beginTransaction(); 
                                    System.out.println(line);
                                    String []s=line.split("[,]");
                                    System.out.println(s[0]);
                                    System.out.println(s[1]);
                                    System.out.println(Float.parseFloat(s[5]));
                                    System.out.println(Float.parseFloat(s[6]));
                                    e1.setLocId((s[0]));
                                    e1.setCity(s[1]);
                                    e1.setLatitude((s[5]));
                                    e1.setLongitude((s[6]));
                                session.save(e1);
                                t.commit();//transaction is commited  
                                session.close(); 
                    }
                    else{
                    count++;}
                }
                                      
} 
            catch(IOException e){}
 
            //task 2:Developing an interface for user to search a city and find out its latitudes and longitudes.
 String a, b;
Double latsa = null, latsb = null;
 Double longsa = null, longsb = null;
 Scanner scanner=new Scanner(System.in);
 a=scanner.nextLine();
 a="\""+a+"\"";
 b=scanner.nextLine();
 b="\""+b+"\"";
                 Transaction tx;
                 
    Session session=factory.openSession();  
    try{
       // int index=0;
         tx = session.beginTransaction();
         List employees = session.createQuery("FROM City").list(); 
         for (Iterator iterator = 
                           employees.iterator(); iterator.hasNext();){
            Records c = (Records) iterator.next(); 
            if(a.contentEquals(c.getCity())){
               
            System.out.print("Name: " + c.getCountry()); 
            System.out.print(" City: " + c.getCity()); 
            latsa=Double.parseDouble(c.getLongitude());
            longsa=Double.parseDouble(c.getLatitude());
            System.out.print("  Longitude: " + c.getLongitude()); 
            System.out.println("  Latitude: " + c.getLatitude()); 
           }
             if(b.contentEquals(c.getCity())){
               
            System.out.print("Name: " + c.getCountry()); 
            System.out.print(" City: " + c.getCity()); 
            latsb=Double.parseDouble(c.getLongitude());
            longsb= Double.parseDouble(c.getLatitude());
            System.out.print("  Longitude: " + c.getLongitude()); 
            System.out.println("  Latitude: " + c.getLatitude()); 
           }
             
        }
          //task 3:	Developing an interface for user to find out the distance between two specific cities (which is not a straight line).
         GreatCircle d1=new GreatCircle();
         double dist= d1.distance(latsa, latsb, longsa, longsb);
         System.out.println("Distance between two cities:"+ dist);
         tx.commit();
      }catch (Exception e) {
        e.printStackTrace();
            }
      
    //task 4:	Developing an interface for user to find out any number of cities near a target city or lat/long.
     //TODO: FIX CODE TO FIND NEARBY CITY
    try{
         tx = session.beginTransaction();
         List employees = session.createQuery("FROM City ").list(); 
         for (Iterator iterator = 
                           employees.iterator(); iterator.hasNext();){
            Records c = (Records) iterator.next(); 
            System.out.print("Name: " + c.getCountry()); 
            System.out.print("  Longitude: " + c.getLongitude()); 
            System.out.println("  Latitude: " + c.getLatitude()); 
        }
         tx.commit();
      }catch (HibernateException e) {
        
            }
   
}
    
}
