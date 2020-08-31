package com.nilesh.InstrumentTrackerSystem.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nilesh.InstrumentTrackerSystem.service.InstLoggerServiceImpl;

@SuppressWarnings("serial")
@Component
public class HomeFrame extends JFrame implements ActionListener{
	
	@Autowired
	InstLoggerServiceImpl theInstLoggerServiceImpl;
	
	
    Container container = getContentPane();
    JLabel employeeId = new JLabel("EMPLOYEE ID");
    JLabel instrumentId = new JLabel("INSTRUMENT ID");
    JTextField empIdField = new JTextField();
    JTextField instIdField = new JTextField();
    JButton punch = new JButton("Punch");
    JButton resetButton = new JButton("RESET");


    HomeFrame() {
    
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
    	employeeId.setBounds(50, 150, 100, 30);
    	instrumentId.setBounds(50, 220, 100, 30);
    	empIdField.setBounds(150, 150, 150, 30);
    	instIdField.setBounds(150, 220, 150, 30);
//        showPassword.setBounds(150, 250, 150, 30);
        punch.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);


    }

    public void addComponentsToContainer() {
        container.add(employeeId);
        container.add(instrumentId);
        container.add(empIdField);
        container.add(instIdField);
        container.add(punch);
        container.add(resetButton);
    }

    public void addActionEvent() {
        punch.addActionListener(this);
        resetButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == punch) {
    		Calendar timeNow = Calendar.getInstance();
    		timeNow.getTime();
     
        	String emploId;
        	String instruId;
        	emploId = empIdField.getText();
        	instruId = instIdField.getText();
    		
    		System.out.println(theInstLoggerServiceImpl.insertToTable(timeNow,emploId,instruId));  
        }
        if (e.getSource() == resetButton) {
        	empIdField.setText("");
        	instIdField.setText("");
        }

    }


}
