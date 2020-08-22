package com.nilesh.InstrumentTrackerSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	public InstLoggerEntity() {
	
	}
		
}