package com.nilesh.InstrumentTrackerSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "instrument")
public class InstrumentEntity {

	@Id
	@Column(name = "instID")
	public String instID;

	public String getInstID() {
		return instID;
	}

	public void setEmpID(String empID) {
		this.instID = empID;
	}

	public InstrumentEntity() {
		
	}
	
}
