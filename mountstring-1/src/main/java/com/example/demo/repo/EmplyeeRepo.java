package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Emplyee;

public interface EmplyeeRepo extends JpaRepository<Emplyee, Integer>{

	public Emplyee findByEmail(String email);

	public String findByName(String name);

	public void deleteByName(String name);
	
	List<Emplyee> findBySalaryBetween(int minSalary, int maxSalary);
	
	List<Emplyee> findByRole(String role);

	public Emplyee findOneById(int id);
}
