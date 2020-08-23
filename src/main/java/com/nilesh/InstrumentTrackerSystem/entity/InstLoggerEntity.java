package com.nilesh.InstrumentTrackerSystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "instLogger")
public class InstLoggerEntity {

	@Id
	@Column(name = "instLoggerId")
	public String instLoggerId;
	
	@Column(name = "empId")
	private String empId;
	
	@Column(name = "instId")
	private String instId;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "inTime")
	private java.util.Date inTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "outTime")
	private java.util.Date outTime;
	 
	@Column(name = "entryStatus")
	private Boolean entryStatus;
	
	public Boolean getEntryStatus() {
		return entryStatus;
	}
	public void setEntryStatus(Boolean entryStatus) {
		this.entryStatus = entryStatus;
	}
	public java.util.Date getInTime() {
		return inTime;
	}
	public void setInTime(java.util.Date inTime) {
		this.inTime = inTime;
	}
	public java.util.Date getOutTime() {
		return outTime;
	}
	public void setOutTime(java.util.Date outTime) {
		this.outTime = outTime;
	}
	public String getInstLoggerId() {
		return instLoggerId;
	}
	public void setInstLoggerId(String instLoggerId) {
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
	public InstLoggerEntity(String instLoggerId, String empId, String instId) {
		super();
		this.instLoggerId = instLoggerId;
		this.empId = empId;
		this.instId = instId;
	}
	
	
	public InstLoggerEntity(String empId, String instId, Date inTime, Date outTime, Boolean entryStatus) {
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