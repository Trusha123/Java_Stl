/*
 * @ author trusha.patel@stltech.in
 * @version 1.0
 * @date 18-Feb-2022
 * @copyright Sterlite Technologies Ltd. All rights reserved
 * @description: Demonstrates DB operations ORM
 * */
package com.sterlite.hibernate.main;

import java.util.List;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class JPQLDemo {

	public static <Product> void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		Configuration c = cfg.configure();
		SessionFactory sf = c.buildSessionFactory();
		Session ss = sf.openSession();		
		
		//JPQ
			//Query q = ss.createQuery("from Product");
			//Query q = ss.createQuery("from Product where productName like 'S%' order by brand  ");
			//List<Product> products = q.getResultList();
			//products.forEach((p)->System.out.println(p));
			
		/*Query q = ss.createQuery("select p.name,p.price from Product p");
			List<Object[]> rows = q.getResultList();
		
			for(int i=0;i<rows.size();i++)
			{
				Object [] row = rows.get(i);
				System.out.println("NAme: " + row[0] +
						"\tPrice: " + row[1]);
			}*/
		
		Query q = ss.createQuery("select count(*) from product");
			long rowCount = (long) q.getSingleResult();
			 System.out.println(rowCount);
			 
			 Query qe = ss.createQuery("select max(p.price) from product");
			 
			ss.close();
			
				
				
	}

}
