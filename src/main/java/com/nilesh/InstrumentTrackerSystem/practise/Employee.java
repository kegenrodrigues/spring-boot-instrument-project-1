package com.nilesh.InstrumentTrackerSystem.practise;

public class Employee {
	public String Name, Age, Company, Salary; 

	
	
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String salary) {
		Salary = salary;
	}

	
	public Employee() {
		
	}
	
	public Employee(String name, String age, String company, String salary) 
	{ 
		super(); 
		Name = name; 
		Age = age; 
		Company = company; 
		Salary = salary; 
	} 

	@Override
	public String toString() 
	{ 
	return "Employee [Name=" +Name + ", Age=" + Age + ", Company=" + Company + ", Salary=" + Salary + "]"; 
	} 
}


