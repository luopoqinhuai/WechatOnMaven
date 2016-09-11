package com.reno.testHibernate;

import java.util.Date;

public class userAction {
	private Long id;
	private String fromusername;
	private String tousername;
	private String Context;
	private Date date;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFromusername() {
		return fromusername;
	}
	public void setFromusername(String fromusername) {
		this.fromusername = fromusername;
	}
	public String getTousername() {
		return tousername;
	}
	public void setTousername(String tOusername) {
		tousername = tOusername;
	}
	public String getContext() {
		return Context;
	}
	public void setContext(String context) {
		Context = context;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
