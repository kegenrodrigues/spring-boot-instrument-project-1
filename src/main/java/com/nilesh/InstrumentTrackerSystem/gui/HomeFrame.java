package com.nilesh.InstrumentTrackerSystem.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class HomeFrame extends JFrame implements ActionListener{

    Container container = getContentPane();
    JLabel employeeId = new JLabel("EMPLOYEE ID");
    JLabel instrumentId = new JLabel("INSTRUMENT ID");
    JTextField empIdField = new JTextField();
    JTextField instIdField = new JTextField();
    //JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
    //JFrame theFrame;

//    HomeFrame() {
//    	//theFrame = this;
//        setLayoutManager();
//        setLocationAndSize();
//        addComponentsToContainer();
//        addActionEvent();
//
//    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
    	employeeId.setBounds(50, 150, 100, 30);
    	instrumentId.setBounds(50, 220, 100, 30);
    	empIdField.setBounds(150, 150, 150, 30);
    	instIdField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);


    }

    public void addComponentsToContainer() {
        container.add(employeeId);
        container.add(instrumentId);
        container.add(empIdField);
        container.add(instIdField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            
            userText = empIdField.getText();
            pwdText = instIdField.getText();
            if (userText.equalsIgnoreCase("mehtab") && pwdText.equalsIgnoreCase("12345")) {
            	dispose();
            	MainPanel mainPanel = new MainPanel();
            	mainPanel.go();
                //JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }
        if (e.getSource() == resetButton) {
        	empIdField.setText("");
        	instIdField.setText("");
        }

    }

	
	
	
	
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		
//	}

}
