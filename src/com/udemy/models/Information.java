package com.udemy.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="information")
public class Information implements Serializable {
	

	public Information() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="numara")
	private int id;
	
	@Column(name="ad")
	private String adi;
	
	@Column(name="soyad")
	private String soyadi;
	
	@Column(name="yas")
	private int yas;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="dogumtarihi")
	private Date dogum;
	
	@Temporal(value=TemporalType.TIME)
	@Column(name="kayitarihi")
	private Date kayit;
	

	@Column(name="tarih")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date tarih;
	
	@Embedded
	private Adresler adresler;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getSoyadi() {
		return soyadi;
	}

	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}

	public int getYas() {
		return yas;
	}

	public void setYas(int yas) {
		this.yas = yas;
	}



	public Date getDogum() {
		return dogum;
	}

	public void setDogum(Date dogum) {
		this.dogum = dogum;
	}

	public Date getKayit() {
		return kayit;
	}

	public void setKayit(Date kayit) {
		this.kayit = kayit;
	}

	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}

	public Adresler getAdresler() {
		return adresler;
	}

	public void setAdresler(Adresler adresler) {
		this.adresler = adresler;
	}

	@Override
	public String toString() {
		return "Information [id=" + id + ", adi=" + adi + ", soyadi=" + soyadi + ", yas=" + yas + ", dogum=" + dogum
				+ ", kayit=" + kayit + ", tarih=" + tarih + ", adresler=" + adresler + "]";
}

	
	
	
	
	
	
	
	

}
