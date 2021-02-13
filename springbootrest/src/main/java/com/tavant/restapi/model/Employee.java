package com.tavant.restapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	
	private Integer employeeNumber;
	private String firstName;
	private String lastName;
	private String extension;
	private String email;
	private Integer officeCode;
	private Integer reportsTo;
	private String jobTitle;
	

}
