package com.nilesh.InstrumentTrackerSystem.gui;

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nilesh.InstrumentTrackerSystem.entity.EmployeeEntity;
import com.nilesh.InstrumentTrackerSystem.entity.InstrumentEntity;

@Component
public class MainPanel {
	
	@Autowired
	HomeFrame homeFrame;
	
	EmployeeEntity employee;
	
	InstrumentEntity instrument;
	
	public void go() {
		
		//homeFrame.setBackground(new java.awt.Color(79, 141, 151));
        homeFrame.setTitle("Home Page");
        homeFrame.setVisible(true);
        homeFrame.setBounds(10, 10, 370, 600);
        homeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        homeFrame.setResizable(false);
				
	}
	
}