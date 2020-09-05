package com.nilesh.InstrumentTrackerSystem.gui;

import java.awt.Container;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nilesh.InstrumentTrackerSystem.entity.InstLoggerEntity;
import com.nilesh.InstrumentTrackerSystem.service.InstLoggerServiceImpl;
import com.nilesh.InstrumentTrackerSystem.toCSV.CSVFromBean;
import com.nilesh.InstrumentTrackerSystem.toCSV.CsvDatabase;

@SuppressWarnings("serial")
@Component
public class HomeFrame extends JFrame implements ActionListener {

	@Autowired
	InstLoggerServiceImpl theInstLoggerServiceImpl;

	@Autowired
	CSVFromBean theCSVFromBean;
	
	@Autowired
	CsvDatabase csvDatabase;

	JFileChooser chooser = new JFileChooser();
	Container container = getContentPane();
	JLabel employeeId = new JLabel("EMPLOYEE ID");
	JLabel instrumentId = new JLabel("INSTRUMENT ID");
	JTextField empIdField = new JTextField();
	JTextField instIdField = new JTextField();
	JButton punchButton = new JButton("PUNCH");
	JButton resetButton = new JButton("RESET");
	JButton fetchButton = new JButton("FETCH");
	TextArea textArea = new TextArea();
	JOptionPane jOptionPane = new JOptionPane();
	JButton uploadEmployees = new JButton("UPLOAD EMPLOYEE");
	JButton uploadInstruments = new JButton("UPLOAD INSTRUMENT");
	JButton fetchEmployees = new JButton("FETCH EMPLOYEES");
	JButton fetchInstruments = new JButton("FETCH INSTRUMENTS");

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
		punchButton.setBounds(50, 300, 100, 30);
		resetButton.setBounds(200, 300, 100, 30);
		fetchButton.setBounds(50, 360, 100, 30);
		uploadEmployees.setBounds(50, 420, 200, 30);
		uploadInstruments.setBounds(50, 480, 200, 30);
		fetchEmployees.setBounds(50, 510, 200, 30);
		fetchInstruments.setBounds(50, 550, 200, 30);
	}

	public void addComponentsToContainer() {
		container.add(employeeId);
		container.add(instrumentId);
		container.add(empIdField);
		container.add(instIdField);
		container.add(punchButton);
		container.add(resetButton);
		container.add(fetchButton);
		container.add(uploadEmployees);
		container.add(uploadInstruments);
		container.add(fetchEmployees);
		container.add(fetchInstruments);
		
	}

	public void addActionEvent() {
		punchButton.addActionListener(this);
		resetButton.addActionListener(this);
		fetchButton.addActionListener(this);
		uploadEmployees.addActionListener(this);
		uploadInstruments.addActionListener(this);
		fetchEmployees.addActionListener(this);
		fetchInstruments.addActionListener(this);
	}

	//MAKE INNER CLASSES AND OPTIMIZE CODE
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String emploId = "";
		String instruId = "";
		String path = "";
		List<InstLoggerEntity> instLogList = null;
		

		if (e.getSource() == punchButton) {
			Calendar timeNow = Calendar.getInstance();
			timeNow.getTime();

			emploId = empIdField.getText();
			instruId = instIdField.getText();

		
			instLogList = theInstLoggerServiceImpl.insertToTable(timeNow, emploId, instruId);
			
			if(emploId.isEmpty() || instruId.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Employee and/or Instrument ID fields cannot be blank", "Invalid Input",
						JOptionPane.ERROR_MESSAGE);
			}else if (instLogList == null) {
				JOptionPane.showMessageDialog(this, "Employee or Instrument not present in database", "Invalid Input",
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Successfully inserted in database.");

			}
			empIdField.setText("");
			instIdField.setText("");
			
		}
		
		if (e.getSource() == resetButton) {
			empIdField.setText("");
			instIdField.setText("");
		}
		
		if (e.getSource() == fetchButton) {
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			chooser.setDialogTitle("Select folder to Download");
			chooser.showSaveDialog(null);
			path = chooser.getSelectedFile().toString();
	        try {
	        	theCSVFromBean.fetchReport(path);
				JOptionPane.showMessageDialog(this, "File Downloaded to "+path);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Check the path and try again later.");
			}
		}
		
		if(e.getSource()==uploadEmployees) {
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.setDialogTitle("Select Employees CSV");
			int result = chooser.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
			    File selectedFile = chooser.getSelectedFile();
			    try {
					csvDatabase.csvToEmpDatabase(selectedFile);
					JOptionPane.showMessageDialog(this, "Employee(s) saved successfully in DB");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, "Could not save to DB. Check CSV and try again later.");
				}
			    
			}
		}
		
		if(e.getSource()==uploadInstruments) {
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.setDialogTitle("Select Instruments CSV");
			int result = chooser.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
			    File selectedFile = chooser.getSelectedFile();
			    try {
					csvDatabase.csvToInstDatabase(selectedFile);
					JOptionPane.showMessageDialog(this, "Instrument(s) saved successfully in DB");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, "Could not save to DB. Check CSV and try again later.");
				}
			}
		}
		
		if(e.getSource()==fetchEmployees) {
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			chooser.setDialogTitle("Select folder to Download");
			chooser.showSaveDialog(null);
	        path = chooser.getSelectedFile().toString();
	        try {
				theCSVFromBean.fetchEmployees(path);
				JOptionPane.showMessageDialog(this, "File Downloaded to "+path);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Check the path and try again later.");
			}
			
		}
		
		if(e.getSource()==fetchInstruments) {
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			chooser.setDialogTitle("Select folder to Download");
			chooser.showSaveDialog(null);
	        path = chooser.getSelectedFile().toString();
	        try {
				theCSVFromBean.fetchInstruments(path);
				JOptionPane.showMessageDialog(this, "File Downloaded to "+path);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Check the path and try again later.");
			}
			
		}
	}
	
}
