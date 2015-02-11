package org.testhibernate;


import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.testhibernate.entity.AnnotationExhibitor;
import org.testhibernate.entity.CreditCardPayment;
import org.testhibernate.entity.Exhibitor;
import org.testhibernate.entity.Payment;
import org.testhibernate.entity.WirePayment;

/**
 * @author makar
 * Date: Feb 11, 2015
 * Time: 12:30:19 PM
 */
public class Main {
	private static final String DOTS = "------------------";
	public static void main(String[] args) {
//		create();
//		read();
//		readList();
//		update();
//		delete();
		
//		createEntityAnnotation();
//		readEntityAnnotation();
//		readListEntityAnnotation();
//		updateEntityAnnotation();
//		deleteEntityAnnotation();
		
//		simpleHQLQuery();
		
//		polymorphicQuery();
		
//		namedQuery();
		
		namedParameterBinding();
	}
	
	public static void namedParameterBinding(){
		Session session = null;
		try{
			session = buildSession();
			System.out.println("Executing Polymorphic HQL");
			
			Query query = session.createSQLQuery("SELECT * FROM exhibitor WHERE name ilike :name").
					addEntity(AnnotationExhibitor.class);
			
			List<AnnotationExhibitor> list = query.
					setString("name", "%jew%").
					list();
			
			System.out.println("Retrieving "+list.size()+" Records:");
			
			Iterator<AnnotationExhibitor> it = list.iterator();
			while(it.hasNext()){
				AnnotationExhibitor exhibitor = it.next();
				System.out.println("Id: "+exhibitor.getId());
				System.out.println("Name: "+exhibitor.getName());
				System.out.println(DOTS);
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	public static void namedQuery(){
		Session session = null;
		try{
			session = buildSession();
			System.out.println("Name Query");
			
			Query query = session.getNamedQuery("findExhibitorByID");
			query.setInteger("exhibitorId", 11);
			
			List<Exhibitor> list = query.list();
			
			ListIterator<Exhibitor> it = list.listIterator();
			while(it.hasNext()){
				Exhibitor exhibitor = it.next();
				System.out.println("Exhibitor id: "+exhibitor.getId());
				System.out.println("Name: "+exhibitor.getName());
				System.out.println();
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(session != null){
				session.flush();
				session.close();
			}
		}
	}
	
	public static void polymorphicQuery(){
		Session session = null;
		try{
			session = buildSession();
			System.out.println("Executing Polymorphic HQL");
			
			List<Payment> results = session.createQuery("from Payment p").list();
			System.out.println("Retrieving "+results.size()+" Records:");
			Iterator<Payment> it = results.iterator();
			
			while(it.hasNext()){
				Payment p = it.next();
				System.out.println(DOTS);
				if(p instanceof CreditCardPayment){
					System.out.println("Credit Card Payment");
					System.out.println(DOTS);
					CreditCardPayment cc = (CreditCardPayment) p;
					System.out.println("PaymentId: "+cc.getPaymentID());
					System.out.println("Credi Card Number: "+cc.getCreditCardNumber());
				}
				
				if(p instanceof WirePayment){
					System.out.println("Wire Payment");
					System.out.println(DOTS);
					WirePayment wire = (WirePayment) p;
					System.out.println("PaymentId: "+wire.getPaymentID());
					System.out.println("BankName: "+wire.getBankName());
					System.out.println("BankRef: "+wire.getBankRef());
				}
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	public static void simpleHQLQuery(){
		try{
			Session session = buildSession();
			System.out.println("Executing Simple HQL");
			
			List<AnnotationExhibitor> results = session.createQuery("from AnnotationExhibitor").list();
			System.out.println("Retrieving "+results.size()+" Recoreds:");
			for(Iterator<AnnotationExhibitor> it = results.iterator();it.hasNext();){
				AnnotationExhibitor exhibitor = it.next();
				System.out.println(DOTS);
				System.out.println(exhibitor);
				System.out.println("exhibitor shorname:"+exhibitor.getShortName());
				System.out.println(DOTS);
				exhibitor.setShortName("new shortname");
			}
			
			session.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void deleteEntityAnnotation(){
		Session session = null;
		try{
			session = buildSession();
			session.beginTransaction();
			
			AnnotationExhibitor exhibitor = new AnnotationExhibitor();
			exhibitor.setId(250003);
			
			session.delete(exhibitor);
			session.getTransaction().commit();
			System.out.println("Done!");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(session != null){
				session.flush();
				session.close();
			}
		}
	}
	
	public static void updateEntityAnnotation(){
		Session session = null;
		try{
			session = buildSession();
			session.beginTransaction();
			
			String HQL_QUERY="from AnnotationExhibitor exhibitor where exhibitor.id= :exhibitorId";
			Query query = session.createQuery(HQL_QUERY);
			//Prepared statement
			query.setParameter("exhibitorId", 9);
			
			for(Iterator<AnnotationExhibitor> it = query.iterate();it.hasNext();){
				AnnotationExhibitor exhibitor = it.next();
				System.out.println(DOTS);
				System.out.println(exhibitor);
				System.out.println("exhibitor shorname:"+exhibitor.getShortName());
				System.out.println(DOTS);
				exhibitor.setShortName("new shortname");
			}
			
			session.getTransaction().commit();
			System.out.println("Done!");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(session != null){
				session.flush();
				session.close();
			}
		}
	}
	
	public static void readListEntityAnnotation(){
		Session session = null;
		try{
			session = buildSession();
			session.beginTransaction();
			
			String HQL_QUERY="from AnnotationExhibitor exhibitor";
			Query query = session.createQuery(HQL_QUERY);
			
			List<AnnotationExhibitor> list = query.list();
			
			System.out.println("Retrieveing "+list.size()+" Records:");
			
//			for(Iterator<AnnotationExhibitor> it = list.iterator();it.hasNext();){
//				AnnotationExhibitor exhibitor = it.next();
//				System.out.println(DOTS);
//				System.out.println(exhibitor);
//				System.out.println(DOTS);
//			}
			
			session.getTransaction().commit();
			System.out.println("Done!");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(session != null){
				session.flush();
				session.close();
			}
		}
	}
	
	public static void readEntityAnnotation(){
		Session session = null;
		try{
			session = buildSession();
			session.beginTransaction();
			
			String HQL_QUERY="from AnnotationExhibitor exhibitor";
			Query query = session.createQuery(HQL_QUERY);
			
			System.out.println("Reading values...");
			
			for(Iterator<AnnotationExhibitor> it = query.iterate();it.hasNext();){
				AnnotationExhibitor exhibitor = it.next();
				System.out.println(DOTS);
				System.out.println(exhibitor);
				System.out.println(DOTS);
			}
			
			session.getTransaction().commit();
			System.out.println("Done!");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(session != null){
				session.flush();
				session.close();
			}
		}
	}
	
	public static void createEntityAnnotation(){
		Session session = null;
		try{
			session = buildSession();
			session.beginTransaction();
			
			System.out.println("Adding a customer record!");
			AnnotationExhibitor exhibitor = new AnnotationExhibitor();
			exhibitor.setName("hibernate test exhibitor");
			exhibitor.setShortName("test exhibitor");
			
			session.save(exhibitor);
			session.getTransaction().commit();
			System.out.println("Done!");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(session != null){
				session.flush();
				session.close();
			}
		}
	}
	
	public static void delete(){
		Session session = null;
		try{
			session = buildSession();
			session.beginTransaction();
			
			Exhibitor exhibitor = new Exhibitor();
			exhibitor.setId(250002);
			
			session.delete(exhibitor);
			session.getTransaction().commit();
			System.out.println("Done!");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(session != null){
				session.flush();
				session.close();
			}
		}
	}
	
	public static void update(){
		Session session = null;
		try{
			session = buildSession();
			session.beginTransaction();
			
			String HQL_QUERY="from Exhibitor exhibitor where exhibitor.id= :exhibitorId";
			Query query = session.createQuery(HQL_QUERY);
			//Prepared statement
			query.setParameter("exhibitorId", 11);
			
			for(Iterator<Exhibitor> it = query.iterate();it.hasNext();){
				Exhibitor exhibitor = it.next();
				System.out.println(DOTS);
				System.out.println(exhibitor);
				System.out.println("exhibitor shorname:"+exhibitor.getShortName());
				System.out.println(DOTS);
				exhibitor.setShortName("new shortname");
			}
			
			session.getTransaction().commit();
			System.out.println("Done!");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(session != null){
				session.flush();
				session.close();
			}
		}
	}
	
	public static void readList(){
		Session session = null;
		try{
			session = buildSession();
			session.beginTransaction();
			
			String HQL_QUERY="from Exhibitor exhibitor";
			Query query = session.createQuery(HQL_QUERY);
			
			List<Exhibitor> list = query.list();
			
			System.out.println("Retrieveing "+list.size()+" Records:");
			
//			for(Iterator<Exhibitor> it = list.iterator();it.hasNext();){
//				Exhibitor exhibitor = it.next();
//				System.out.println(DOTS);
//				System.out.println(exhibitor);
//				System.out.println(DOTS);
//			}
			
			session.getTransaction().commit();
			System.out.println("Done!");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(session != null){
				session.flush();
				session.close();
			}
		}
	}
	
	public static void read(){
		Session session = null;
		try{
			session = buildSession();
			session.beginTransaction();
			
			String HQL_QUERY="from Exhibitor exhibitor";
			Query query = session.createQuery(HQL_QUERY);
			
			System.out.println("Reading values...");
			
			for(Iterator<Exhibitor> it = query.iterate();it.hasNext();){
				Exhibitor exhibitor = it.next();
				System.out.println(DOTS);
				System.out.println(exhibitor);
				System.out.println(DOTS);
			}
			
			session.getTransaction().commit();
			System.out.println("Done!");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(session != null){
				session.flush();
				session.close();
			}
		}
	}
	
	public static void create(){
		Session session = null;
		try{
			session = buildSession();
			session.beginTransaction();
			
			System.out.println("Adding a customer record!");
			Exhibitor exhibitor = new Exhibitor();
			exhibitor.setName("hibernate test exhibitor");
			exhibitor.setShortName("test exhibitor");
			
			session.save(exhibitor);
			session.getTransaction().commit();
			System.out.println("Done!");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(session != null){
				session.flush();
				session.close();
			}
		}
	}
	
	public static Session buildSession(){
		Configuration configuration = new Configuration();
		configuration.configure();
		
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder().
				applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = standardServiceRegistryBuilder.build();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		return sessionFactory.openSession();
	}
}


