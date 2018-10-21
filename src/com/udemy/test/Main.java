package com.udemy.test;

import java.util.Calendar;
import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.udemy.models.Adresler;
import com.udemy.models.Information;

public class Main {

	public static void main(String[] args) {
		

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_001");
		EntityManager entity = factory.createEntityManager();
		
		Date dogumTarihi = new Date(1991, 10, 22);
		
		EntityTransaction tr = entity.getTransaction();
		
		try {
		
Adresler adres = new Adresler();	
		adres.setUlke("Türkiye");
		adres.setSehir("Ýstanbul");
		adres.setMahalle("Esenler");	
Information bilgi = new Information();	
			bilgi.setAdi("sultan");
			bilgi.setSoyadi("Göger");
			bilgi.setYas(26);
			bilgi.setDogum(dogumTarihi); 
			bilgi.setKayit(new Date());
			bilgi.setTarih(new Date());
			bilgi.setAdresler(adres);
			
			tr.begin();
			
			entity.persist(bilgi);
			entity.flush();	
			
			tr.commit();
			
		}catch(Exception e) {
			
			tr.rollback();
			
		}finally {
			entity.close();
			factory.close();
			
		}
	}

}
