package com.te.jpqlassignment.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.jpqlassignment.bean.Employee;

public class EmployeeMain {
	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;
	Scanner scanner = new Scanner(System.in);
	public void findAll() {
		try {
			factory = Persistence.createEntityManagerFactory("jpqlData");
			manager = factory.createEntityManager();
			String findAll = "from Employee";
			Query query = manager.createQuery(findAll);
			List<Employee> list = query.getResultList();
			for (Employee employee : list) {
				System.out.println(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (manager!=null) {
				manager.close();
			}
			if (factory!=null) {
				factory.close();
			}
		}
	}

	public void findParticular() {
		System.out.println("Enter the ID:");
		int id = scanner.nextInt();
		try {
			factory = Persistence.createEntityManagerFactory("jpqlData");
			manager = factory.createEntityManager();
			String findParticular = "from Employee where id= :ID";
			Query query = manager.createQuery(findParticular);
			query.setParameter("ID", id);
			Employee employee = (Employee) query.getSingleResult();
			System.out.println("Data Fetched:");
			System.out.println(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (manager!=null) {
				manager.close();
			}
			if (factory!=null) {
				factory.close();
			}
		}
	}

	public void deleteParticular() {
		System.out.println("Enter the ID:");
		int id = scanner.nextInt();
		String value = null;
		try {
			factory = Persistence.createEntityManagerFactory("jpqlData");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String delete = "delete from Employee where id= :ID";
			Query query = manager.createQuery(delete);
			query.setParameter("ID", id);
			int result = query.executeUpdate();
			System.out.println("Data deleted!!!");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (manager!=null) {
				manager.close();
			}
			if (factory!=null) {
				factory.close();
			}
		}
	}

	public void update() {
		String value = null;
		int number = 0;
		try {
			factory = Persistence.createEntityManagerFactory("jpqlData");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			System.out.println("Enter the ID you want to update:");
			int id = scanner.nextInt();
			do {
				System.out.println("Press 1 to update name:");
				System.out.println("Press 2 to update salary:");
				System.out.println("Press 3 to update designation:");
				System.out.println("Enter the number:");
				number = scanner.nextInt();
				switch (number) {
				case 1: 
				System.out.println("Enter the name:");
				String name = scanner.next();
				String updateName = "update from Employee set name= :Name where id= :ID1";
				Query query = manager.createQuery(updateName);
				query.setParameter("ID1", id);
				query.setParameter("Name", name);
				int result = query.executeUpdate();
				System.out.println("Name updated!!!!");

				break;
				case 2: 
				System.out.println("Enter the salary:");
				double salary = scanner.nextDouble();
				String updateSal = "update from Employee set salary= :Salary where id= :ID2";
				Query query1 = manager.createQuery(updateSal);
				query1.setParameter("Salary", salary);
				query1.setParameter("ID2", id);
				result = query1.executeUpdate();
				System.out.println("Salary updated!!!");
				break;
				
				case 3: 
				System.out.println("Enter the designation:");
				String designation = scanner.next();
				String updateDesig = "update from Employee set designation= :Designation where id= :ID3";
				query = manager.createQuery(updateDesig);
				query.setParameter("Designation", designation);
				query.setParameter("ID3", id);
				result = query.executeUpdate();
				System.out.println("Designation updated!!!");
				break;
				default:throw new InvalidOptionException("Invalid number!!");
				}
			} while (value.equalsIgnoreCase("y"));
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateParticular() {
		try {
			factory = Persistence.createEntityManagerFactory("jpqlData");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String output = null;
			Query query = null;
			int result = 0;
			transaction.begin();
			System.out.println("Enter the ID you want to update:");
			int id = scanner.nextInt();
			do {
				System.out.println("Do you want to update name?(yes/no)");
				output = scanner.next();
				System.out.println("Enter the name:");
				String name = scanner.next();
				String updateName = "update from Employee set name= :Name where id= :ID1";
				query = manager.createQuery(updateName);
				query.setParameter("ID1", id);
				query.setParameter("Name", name);
				result = query.executeUpdate();
				System.out.println("Name updated!!!!");
				System.out.println("----------------------");
				System.out.println("Do you want to update the salary?(yes/no)");
				output = scanner.next();
				System.out.println("Enter the salary:");
				double salary = scanner.nextDouble();
				String updateSal = "update from Employee set salary= :Salary where id= :ID2";
				query = manager.createQuery(updateSal);
				query.setParameter("Salary", salary);
				query.setParameter("ID2", id);
				result = query.executeUpdate();
				System.out.println("Salary updated!!!");
				System.out.println("-------------------------");
				System.out.println("Do you want to update the designation?(yes/no)");
				output = scanner.next();
				System.out.println("Enter the designation:");
				String designation = scanner.next();
				String updateDesig = "update from Employee set designation= :Designation where id= :ID3";
				query = manager.createQuery(updateDesig);
				query.setParameter("Designation", designation);
				query.setParameter("ID3", id);
				result = query.executeUpdate();
				System.out.println("Designation updated!!!");
				transaction.commit();
			} while (output.equalsIgnoreCase("yes"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (manager!=null) {
				manager.close();
			}
			if (factory!=null) {
				factory.close();							
			}
		}
	}
}
