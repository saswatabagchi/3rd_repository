package com.assignment.simplejosn;



public class Employee implements Comparable<Employee> {
	
	private String name;
	private int age ;
	private double salary ;
	private String dept ;
	private String designation ;
	
	
	

	


	public Employee(String name, int age, double salary, String dept, String designation) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.dept = dept;
		this.designation = designation;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", dept=" + dept + ", designation="
				+ designation + "]";
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	@Override
	public int compareTo(Employee o) {
		  
		
		int str1_ch = (int)this.name.charAt(0); 
        int str2_ch = (int)o.name.charAt(0); 
        int result = str1_ch - str2_ch;
        System.out.println(result);
        return result; 

	}

}
