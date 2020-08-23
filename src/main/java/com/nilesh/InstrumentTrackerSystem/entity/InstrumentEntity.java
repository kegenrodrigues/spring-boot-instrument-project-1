package com.nilesh.InstrumentTrackerSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "instrument")
public class InstrumentEntity {

	@Id
	@Column(name = "instId")
	public String instId;

	public String getInstId() {
		return instId;
	}

	public void setInstId(String empId) {
		this.instId = empId;
	}

	public InstrumentEntity() {
		
	}
	
}
