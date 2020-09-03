package com.nilesh.InstrumentTrackerSystem.gui;

import java.awt.Container;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

@SuppressWarnings("serial")
@Component
public class HomeFrame extends JFrame implements ActionListener {

	@Autowired
	InstLoggerServiceImpl theInstLoggerServiceImpl;

	@Autowired
	CSVFromBean theCSVFromBean;

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
		fetchButton.setBounds(150, 360, 100, 30);
	}

	public void addComponentsToContainer() {
		container.add(employeeId);
		container.add(instrumentId);
		container.add(empIdField);
		container.add(instIdField);
		container.add(punchButton);
		container.add(resetButton);
		container.add(fetchButton);
	}

	public void addActionEvent() {
		punchButton.addActionListener(this);
		resetButton.addActionListener(this);
		fetchButton.addActionListener(this);
	}

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
			if (instLogList == null) {
				JOptionPane.showMessageDialog(this, "Employee or Instrument not present in database", "Invalid Input",
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Successfully inserted in database.");
			}
		}
		if (e.getSource() == resetButton) {
			empIdField.setText("");
			instIdField.setText("");
		}
		if (e.getSource() == fetchButton) {
			
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			
			chooser.setDialogTitle("Select folder please");
			chooser.showSaveDialog(null);
	        path = chooser.getSelectedFile().toString();
	        theCSVFromBean.fetchReport(path);
			JOptionPane.showMessageDialog(this, "File Downloaded to "+path);
		}
	}
}
