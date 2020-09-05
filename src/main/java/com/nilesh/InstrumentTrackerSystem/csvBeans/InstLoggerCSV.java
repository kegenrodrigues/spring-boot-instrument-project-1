package com.nilesh.InstrumentTrackerSystem.csvBeans;


public class InstLoggerCSV {
	
	public Long instLoggerId;
	

	private String empId;
	private String instId;
	private String inTime;
	private String outTime;
	private String currentDate;
	private String modelNo;
	private String iP;
	
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
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

	public InstLoggerCSV(){	
		
	}
	
	public InstLoggerCSV(Long instLoggerId, String empId, String instId, String inTime, String outTime) {
		super();
		this.instLoggerId = instLoggerId;
		this.empId = empId;
		this.instId = instId;
		this.inTime = inTime;
		this.outTime = outTime;
	}
	
	public InstLoggerCSV(Long instLoggerId, String empId, String instId, String inTime, String outTime,
			String currentDate, String modelNo, String iP) {
		super();
		this.instLoggerId = instLoggerId;
		this.empId = empId;
		this.instId = instId;
		this.inTime = inTime;
		this.outTime = outTime;
		this.currentDate = currentDate;
		this.modelNo = modelNo;
		this.iP = iP;
	}
	
}
