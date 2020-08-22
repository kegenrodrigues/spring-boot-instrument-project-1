package com.nilesh.InstrumentTrackerSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

	@Id
	@Column(name = "empID")
	public String empID;

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public EmployeeEntity() {
		
	}
	
	
	
}
