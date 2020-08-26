package com.nilesh.InstrumentTrackerSystem.gui;

import java.util.Scanner;

import javax.swing.JFrame;

import org.springframework.stereotype.Component;

import com.nilesh.InstrumentTrackerSystem.entity.EmployeeEntity;
import com.nilesh.InstrumentTrackerSystem.entity.InstrumentEntity;

@Component
public class MainPanel {
	
	EmployeeEntity employee;
	InstrumentEntity instrument;
	
	public void go() {

		HomeFrame homeFrame = new HomeFrame();
        homeFrame.setTitle("Home Page");
        homeFrame.setVisible(true);
        homeFrame.setBounds(10, 10, 370, 600);
        homeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        homeFrame.setResizable(false);
		

		
	}
	
}


//Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
//System.out.println("Enter the employee ID");
//
//
//String employeeId= sc.nextLine();              //reads string  
//System.out.print("You have entered: "+employeeId);    
//
//System.out.println("Enter the instrument ID");
//String instrumentId= sc.nextLine();              //reads string  
//System.out.print("You have entered: "+instrumentId);    
//



//JFrame frame = new JFrame();
//JPanel panel = new JPanel();
//
//System.out.println("Hi");
//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//frame.setSize(screenSize.width, screenSize.height);
//frame.setVisible(true);
//
//panel.setBackground(Color.DARK_GRAY);
//frame.getContentPane().add(BorderLayout.CENTER,panel);
//frame.setSize(200, 200);
//
//JLabel usernameLabel = new JLabel("Enter Username");
//JTextField usernameField = new JTextField("Enter your username here");
//
//usernameLabel.setBounds(50,50,50,50);
//usernameField.setBounds(70,70,70,70);
//panel.add(usernameLabel);
//panel.add(usernameField);
