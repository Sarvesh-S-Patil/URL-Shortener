package com.Sarvesh.SpringBootJPA.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Url-list")
public class Url {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="longURL")
	private String longUrl;
	@Column(name="Created Date")
	private Date createdDate;
	@Column(name="ExpiryDate")
	private Date expiryDate;
	
	
	public Url() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Url(long id, String longUrl, Date createdDate, Date expiryDate) {
		super();
		this.id = id;
		this.longUrl = longUrl;
		this.createdDate = createdDate;
		this.expiryDate = expiryDate;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getLongUrl() {
		return longUrl;
	}


	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Date getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	
	
	

}
