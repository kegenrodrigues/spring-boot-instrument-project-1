package com.nilesh.InstrumentTrackerSystem.entity;


public class InstLoggerCSV {
	
	public Long instLoggerId;
	

	private String empId;
	private String instId;
	private String inTime;
	private String outTime;
	private Boolean entryStatus;
	
	public Long getInstLoggerId() {
		return instLoggerId;
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
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public Boolean getEntryStatus() {
		return entryStatus;
	}
	public void setEntryStatus(Boolean entryStatus) {
		this.entryStatus = entryStatus;
	}
	public InstLoggerCSV(Long instLoggerId, String empId, String instId, String inTime, String outTime,
			Boolean entryStatus) {
		super();
		this.instLoggerId = instLoggerId;
		this.empId = empId;
		this.instId = instId;
		this.inTime = inTime;
		this.outTime = outTime;
		this.entryStatus = entryStatus;
	}
	
	public InstLoggerCSV(){
		
	}
	
	
	
}
