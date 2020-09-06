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
	JLabel modelNo = new JLabel("Model No");
	JLabel iP = new JLabel("IP");
	
	JTextField empIdField = new JTextField();
	JTextField instIdField = new JTextField();
	JTextField modelNoField = new JTextField();
	JTextField ipField = new JTextField();
	
	JButton punchButton = new JButton("PUNCH");
	JButton downloadButton = new JButton("DOWNLOAD");
	TextArea textArea = new TextArea();
	JOptionPane jOptionPane = new JOptionPane();
	JButton uploadEmployees = new JButton("UPLOAD EMP");
	JButton uploadInstruments = new JButton("UPLOAD INST");
	JButton fetchEmployees = new JButton("FETCH EMP");
	JButton fetchInstruments = new JButton("FETCH INST");

	HomeFrame() {
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
	}

	public void setLayoutManager() {
		container.setLayout(null);
		container.setBackground(new java.awt.Color(190, 190, 190));
	}

	public void setLocationAndSize() {
		employeeId.setBounds(50, 20, 100, 30);
		instrumentId.setBounds(50, 70, 100, 30);
		modelNo.setBounds(50, 120, 100, 30);
		iP.setBounds(50, 170, 100, 30);
		
		empIdField.setBounds(150, 20, 150, 30);
		instIdField.setBounds(150, 70, 150, 30);
		modelNoField.setBounds(150, 120, 100, 30);
		ipField.setBounds(150, 170, 100, 30);
		
		
		punchButton.setBounds(50, 300, 120, 30);
		downloadButton.setBounds(200, 300, 120, 30);
		uploadEmployees.setBounds(50, 350, 120, 30);
		uploadInstruments.setBounds(200, 350, 120, 30);
		fetchEmployees.setBounds(50, 400, 120, 30);
		fetchInstruments.setBounds(200, 400, 120, 30);
	}

	public void addComponentsToContainer() {
		container.add(employeeId);
		container.add(instrumentId);
		container.add(empIdField);
		container.add(instIdField);
		container.add(modelNo);
		container.add(iP);
		container.add(modelNoField);
		container.add(ipField);
		
		container.add(punchButton);
		container.add(downloadButton);
		container.add(uploadEmployees);
		container.add(uploadInstruments);
		container.add(fetchEmployees);
		container.add(fetchInstruments);		
	}

	public void addActionEvent() {
		punchButton.addActionListener(this);
		downloadButton.addActionListener(this);
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
		String modelNo = "";
		String iP = "";
		
		String path = "";
		List<InstLoggerEntity> instLogList = null;
		

		if (e.getSource() == punchButton) {
			Calendar timeNow = Calendar.getInstance();
			timeNow.getTime();

			emploId = empIdField.getText();
			instruId = instIdField.getText();
			modelNo = modelNoField.getText();
			iP = ipField.getText();
		
			instLogList = theInstLoggerServiceImpl.insertToTable(timeNow, emploId, instruId, modelNo,iP);
			
			if(emploId.isEmpty() || instruId.isEmpty()||modelNo.isEmpty()||iP.isEmpty()) {
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
			modelNoField.setText("");
			ipField.setText("");
		}
		
		if (e.getSource() == downloadButton) {
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
