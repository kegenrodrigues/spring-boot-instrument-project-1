package com.nilesh.InstrumentTrackerSystem.gui;

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Login {    
	@Autowired
	LoginFrame frame;
	
    public void makeLoginPage() {
          frame.setTitle("Login Form");
          frame.setVisible(true);
          frame.setBounds(10, 10, 370, 600);
          frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          frame.setResizable(false);
    }
}



