package com.leclex;

public class MyProgram {
	public static void main(String[] args) {
		Student firstStudent = new Student();
		Student secondStudent = new Student();
		firstStudent.id = 1;
		firstStudent.firstName = "Marc";
		secondStudent.id = 2;
		secondStudent.firstName = "Sophie";
		
		System.out.println("The student object referred to " +
		"by the variable secondStudent has the first " +
				"name: " + secondStudent.firstName);
	}
}
