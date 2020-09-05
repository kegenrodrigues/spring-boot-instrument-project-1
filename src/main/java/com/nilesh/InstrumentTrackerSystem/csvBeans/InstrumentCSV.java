package com.nilesh.InstrumentTrackerSystem.csvBeans;

public class InstrumentCSV {
	public String instId;

	public String modelNo;
	
	public String iP;
	
	public String getInstId() {
		return instId;
	}

	public void setInstId(String instId) {
		this.instId = instId;
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

	public InstrumentCSV() {
		
	}
	
	public InstrumentCSV(String instId) {
		this.instId = instId;
	}
}
