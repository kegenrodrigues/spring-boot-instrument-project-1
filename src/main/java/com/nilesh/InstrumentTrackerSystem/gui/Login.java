package com.nilesh.InstrumentTrackerSystem.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import org.springframework.stereotype.Component;

@Component
public class Login {    
    public void makeLoginPage() {
    	  LoginFrame frame = new LoginFrame();
          frame.setTitle("Login Form");
          frame.setVisible(true);
          frame.setBounds(10, 10, 370, 600);
          frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          frame.setResizable(false);
    }
}



