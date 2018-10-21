package com.udemy.controller;

import java.io.IOException;
import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.udemy.models.Adresler;
import com.udemy.models.Information;


@WebServlet("/KayitSayfasi")
public class KayitSayfasi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//	@PersistenceContext(unitName="JPA_001")
//	private EntityManager entity;
	
	EntityManagerFactory factory;
	EntityManager entity;
	
    public KayitSayfasi() {
    	 super();
    	 factory = Persistence.createEntityManagerFactory("JPA_001");
		 entity = factory.createEntityManager();
       
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());

		Date dogumTarihi = new Date(1991, 10, 22);
		
		//UserTransaction t;
		EntityTransaction t;
		try {
			t = entity.getTransaction();
			
		//	t = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");
			
			t.begin();
			
			Adresler adres = new Adresler();	
			adres.setUlke("Türkiye");
			adres.setSehir("Ýstanbul");
			adres.setMahalle("Esenler");	
	Information bilgi = new Information();	
				bilgi.setAdi("Sercan");
				bilgi.setSoyadi("Göger");
				bilgi.setYas(26);
				bilgi.setDogum(new Date()); 
				bilgi.setKayit(new Date());
				bilgi.setTarih(new Date());
				bilgi.setAdresler(adres);
				
				entity.persist(bilgi);
				entity.flush();
			t.commit();
		
		} catch ( SecurityException | IllegalStateException e) {
			
			e.printStackTrace();
		}
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
