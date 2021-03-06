// NamedParameterJdbcTemplateTest.java (Client Application)

package com.nt.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

public class NamedParameterJdbcTemplateTest {

	public static void main(String[] args) {
		// create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get DAO class obj ref
		IEmployeeDAO dao = ctx.getBean("empDAO", IEmployeeDAO.class);
		try {
			// invoke the methods
			int count = dao.getEmployeesCountByRange(5000.0, 20000.0);
			System.out.println("5000 to 7000 Sal range employees count is :: " + count);
		} // try
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("______________________");
		try {
			List<Employee> list = dao.getEmployeesByNameChars("A");
			if (list.size() != 0)
				list.forEach(System.out::println);
			else
				System.out.println("No record found");
		} // try
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("___________________________");
		try {
			Employee emp = new Employee(1001, "Suresh", "Manager", 9000.0, 20);
			int count = dao.registrEmployee(emp);
			System.out.println(count == 0 ? "Emp not registered" : "Employee already registered");
		} // try
		catch (Exception e) {
			e.printStackTrace();
		}
		// close container
		ctx.close();
	} // main
} // class
