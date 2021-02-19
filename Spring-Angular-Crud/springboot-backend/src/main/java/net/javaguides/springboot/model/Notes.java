package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notes")
public class Notes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "auther")
	private String auther;

	@Column(name = "first_par")
	private String firstPar;
	
	@Column(name = "last_par")
	private String lastPar;
	
	public Notes() {
		
	}
	
	public Notes(String auther, String firstPar, String lastPar) {
		super();
		this.auther = auther;
		this.firstPar = firstPar;
		this.lastPar = lastPar;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public String getFirstPar() {
		return firstPar;
	}
	public void setFirstPar(String firstPar) {
		this.firstPar = firstPar;
	}
	public String getLastPar() {
		return lastPar;
	}
	public void setLastPar(String lastPar) {
		this.lastPar = lastPar;
	}
}
