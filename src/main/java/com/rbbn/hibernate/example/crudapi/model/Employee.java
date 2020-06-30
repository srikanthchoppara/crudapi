package com.rbbn.hibernate.example.crudapi.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Indexed (index="tbl_employee")
@Table(name="tbl_employee")
@Getter
@Setter
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	@GenericField
	private Integer id;
	@Column
	@GenericField
	private String name;
	@Column
	@GenericField
	private String gender;
	@Column
	@GenericField
	private String department;
	@Column
	@GenericField
	private String dob;

	public Employee(int id, String name, String department, String gender, String dob) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.gender = gender;
		this.dob = dob;
	}

	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", department=" + department + ", dob="
				+ dob + "]";
	}
}
