package com.te.jpqlassignment.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Employee_Details")
public class Employee implements Serializable{
	@Id
	@Column(name = "emp_id")
	private int id;
	@Column(name = "emp_name")
	private String name;
	@Column(name = "emp_sal")
	private double salary;
	@Column(name = "emp_desig")
	private String designation;
}
