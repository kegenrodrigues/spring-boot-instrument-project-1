package com.nilesh.InstrumentTrackerSystem.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "instlogger")//Let the name be instlogger
public class InstLoggerEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "instLoggerId")//Do not change
	public Long instLoggerId;
	
	@Column(name = "empId")
	private String empId;
	
	@Column(name = "instId")
	private String instId;
	
	
	//@Temporal(TemporalType.TIMESTAMP) // Check if using this you can retrive time as well from the db
	@Column(name = "inTime")
	//private java.util.Date inTime;
	private Calendar inTime;
	
	//@Temporal(TemporalType.TIMESTAMP) //Check if using this you can retrive time as well from the db
	@Column(name = "outTime")
	//private java.util.Date outTime;
	private Calendar outTime;
	 
	@Column(name = "entryStatus")
	private Boolean entryStatus;
	
	public Boolean getEntryStatus() {
		return entryStatus;
	}
	public void setEntryStatus(Boolean entryStatus) {
		this.entryStatus = entryStatus;
	}
//	public java.util.Date getInTime() {
//		return inTime;
//	}
//	public void setInTime(java.util.Date inTime) {
//		this.inTime = inTime;
//	}
//	public java.util.Date getOutTime() {
//		return outTime;
//	}
//	public void setOutTime(java.util.Date outTime) {
//		this.outTime = outTime;
//	}
	
	public Long getInstLoggerId() {
		return instLoggerId;
	}
	public Calendar getInTime() {
		return inTime;
	}
	public void setInTime(Calendar inTime) {
		this.inTime = inTime;
	}
	public Calendar getOutTime() {
		return outTime;
	}
	public void setOutTime(Calendar outTime) {
		this.outTime = outTime;
	}
	public void setInstLoggerId(Long instLoggerId) {
		this.instLoggerId = instLoggerId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getInstId() {
		return instId;
	}
	public void setInstId(String instId) {
		this.instId = instId;
	}
	public InstLoggerEntity(Long instLoggerId, String empId, String instId) {
		super();
		this.instLoggerId = instLoggerId;
		this.empId = empId;
		this.instId = instId;
	}
	
	
	public InstLoggerEntity(String empId, String instId, Calendar inTime, Calendar outTime, Boolean entryStatus) {
		super();
		this.empId = empId;
		this.instId = instId;
		this.inTime = inTime;
		this.outTime = outTime;
		this.entryStatus = entryStatus;
	}
	public InstLoggerEntity() {
	
	}
		
}