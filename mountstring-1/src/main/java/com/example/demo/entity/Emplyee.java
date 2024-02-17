package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Emplyee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
String name;
String role;
int salary;
String email;
String password;
private String image;
public Emplyee() {
	super();
}
public Emplyee(int id, String name, String role, int salary, String email, String password, String image) {
	super();
	this.id = id;
	this.name = name;
	this.role = role;
	this.salary = salary;
	this.email = email;
	this.password = password;
	this.image = image;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
@Override
public String toString() {
	return "Emplyee [id=" + id + ", name=" + name + ", role=" + role + ", salary=" + salary + ", email=" + email
			+ ", password=" + password + ", image=" + image + "]";
}


}
