package com.udemy.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Adresler {
	
	public Adresler() {}
	
	@Column(name="ulkeniz")
	private String ulke;
	
	@Column(name="sehriniz")
	private String sehir;
	
	@Column(name="mahalleniz")
	private String mahalle;

	public String getUlke() {
		return ulke;
	}

	public void setUlke(String ulke) {
		this.ulke = ulke;
	}

	public String getSehir() {
		return sehir;
	}

	public void setSehir(String sehir) {
		this.sehir = sehir;
	}

	public String getMahalle() {
		return mahalle;
	}

	public void setMahalle(String mahalle) {
		this.mahalle = mahalle;
	}

	@Override
	public String toString() {
		return "Adresler [ulke=" + ulke + ", sehir=" + sehir + ", mahalle=" + mahalle + "]";
	}
	

	

}
