package com.example.demo.servic;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Emplyee;

public interface EmplyeeService {

public	boolean emailExists(String email);

public String addUser(Emplyee emplyee);

public List<Emplyee> fetchAllData();

public Emplyee getEmployeeById(int id);

public void deleteEmplyeeById(int id);

List<Emplyee> fetchBySalaryRange(int minSalary, int maxSalary);

public List<Emplyee> fetchByRole(String role);

public Emplyee findById(int id);

public void deleteEmployeeImage(int id);

public void updateEmployeeImage(int id, MultipartFile imageFile);




//public boolean existss(String name);
//
//public void deleteEmployee(String name);

}
