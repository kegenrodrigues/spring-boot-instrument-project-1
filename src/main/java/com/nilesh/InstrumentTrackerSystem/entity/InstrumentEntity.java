package com.nilesh.InstrumentTrackerSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "instrument")
public class InstrumentEntity {

	@Id
	@Column(name = "instId")//do not change
	public String instId;

	@Column(name = "modelNo")
	public String modelNo;
	
	@Column(name = "iP")
	public String iP;
	
	public String getInstId() {
		return instId;
	}

	public void setInstId(String empId) {
		this.instId = empId;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getiP() {
		return iP;
	}

	public void setiP(String iP) {
		this.iP = iP;
	}

	public InstrumentEntity() {
		
	}
	
}
