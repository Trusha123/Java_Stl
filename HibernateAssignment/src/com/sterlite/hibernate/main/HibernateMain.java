/*
 * @ author trusha.patel@stltech.in
 * @version 1.0
 * @date 18-Feb-2022
 * @copyright Sterlite Technologies Ltd. All rights reserved
 * @description: Demonstrates DB operations ORM
 * */
package com.sterlite.hibernate.main;

//import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sterlite.hibernate.entities.Product;


public class HibernateMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. creating configurations object
		Configuration cfg = new Configuration();
		
		//2. Read hibernate configurations from hibernate.cfg
		Configuration c = cfg.configure();
		
		//3. Build SessionFactory /using Load all read configuration and obtain sessionFactory
		//Heavy weight and singleton object 
		SessionFactory sf = c.buildSessionFactory();
		
		//4. Obtain session from sessionFactory
		//session represent database connection
		//session provides CRUD methods to perform database operations
		//session is Light weight and not singleton
		Session ss = sf.openSession();
		
		//5. Obtain Transaction from session
		org.hibernate.Transaction tx = ss.beginTransaction();
		
		//6. Perform DB operations
		//select,insert,update or delete using ORM
		
			//get row as per primary key int form of object
		Product p = ss.get(Product.class, 3005);
		System.out.println(p);
		
		//add product object as row in DB table(Transient sate)
		/*Product pro = new Product();
		pro.setProductId(3690);
		pro.setProductName("TV");
		pro.setBrand("Sony");
		pro.setPrice(43500);
		
		//after saving product will be in persistent state
		ss.save(pro);
		//System.out.println("Inserted successfully");
		*/
		
		//update existing row using persistent object
		/*Product pr = ss.get(Product.class, 3002);
		if(pr!=null)
		{
			pr.setPrice(p.getPrice() + 1000);
			pr.setBrand("Dell");
			ss.update(pr);
		}
		else
			System.out.println("Sorry!!Product not found");
		*/
		
		//delete row using object of ps class
		Product pr = ss.get(Product.class, 3002);//persistent object
		if(pr!=null)
		{
			pr.setPrice(p.getPrice() + 1000);
			pr.setBrand("Dell");
			ss.delete(pr);
		}
		else
			System.out.println("Sorry!!Product not found");
		
		
		//7. Commit transaction
		tx.commit();//make changes permanent
		
		//8.Close session
		ss.close();//close DB connection
		
	}

}
