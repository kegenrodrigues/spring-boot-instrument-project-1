package com.nilesh.InstrumentTrackerSystem.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


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
	
	@Column(name = "inTime")
	private Calendar inTime;
	
	@Column(name = "outTime")
	private Calendar outTime;
	 
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
	
	public InstLoggerEntity(String empId, String instId, Calendar inTime, Calendar outTime) {
		super();
		this.empId = empId;
		this.instId = instId;
		this.inTime = inTime;
		this.outTime = outTime;
	}
	public InstLoggerEntity() {
	
	}
		
}