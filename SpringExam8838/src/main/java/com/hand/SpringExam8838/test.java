package com.hand.SpringExam8838;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.SpringExam8838.Student;

public class test {
	public static void main(String[] args) {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("ApplicationContext.xml");
	      Student student = (Student) context.getBean("student");
	      student.getName();
	      student.getAge();      
	      student.printThrowException();
	}
}
