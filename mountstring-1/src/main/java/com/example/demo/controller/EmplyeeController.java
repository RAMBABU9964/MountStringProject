package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.entity.Emplyee;
import com.example.demo.servic.EmplyeeService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller

public class EmplyeeController {

	
public EmplyeeController(EmplyeeService service) {
		super();
		this.service = service;
	}
EmplyeeService service;

@PostMapping("/save")
public String saveData(@ModelAttribute Emplyee emplyee) {
  
	service.addUser(emplyee);
	System.out.println("update sucessfully");
    return "redirect:/";
}



@PostMapping("/Register")
public String addUser(@ModelAttribute Emplyee emplyee) {
	boolean userStatus=service.emailExists(emplyee.getEmail());
	if(userStatus==false) {
	service.addUser(emplyee);
	System.out.println("User Added");
	}else {
		
		System.out.println("User Already Exists");
	}
    
    return "redirect:/";
}

@GetMapping("/DataAll")
public String dataAll(Model model) {
	List<Emplyee> allData=service.fetchAllData();
	model.addAttribute("emplyee", allData);
    return "DataAll";
}

@GetMapping("/fetchBySalaryRange")
public  String fetchBySalaryRange(@RequestParam String range, Model model) {
    // Parse the salary range
    String[] ranges = range.split("-");
    int minSalary = Integer.parseInt(ranges[0]);
    int maxSalary = Integer.parseInt(ranges[1]);

    // Call your service method to fetch employees within the specified salary range
    List<Emplyee> employees = service.fetchBySalaryRange(minSalary, maxSalary);
    model.addAttribute("emplyeee", employees);
    return "fetchBySalaryRange";
}


@GetMapping("/fetchByRole")
public String fetchByRole(@RequestParam String role, Model model) {
    // Call the service method to fetch employees with the specified role
    List<Emplyee> employees = service.fetchByRole(role);
    
    // Add the list of employees to the model
    model.addAttribute("employees", employees);
    
    // Return the view name
    return "fetchByRole";
}



@GetMapping("/showFormForUpdate/{id}")
public String showFormForUpdate(@PathVariable(value = "id") int id,Model model) {
	
	Emplyee emplyee=service.getEmployeeById(id);
	
	model.addAttribute("employee", emplyee);
    return "EditEmp";
}
@GetMapping("/deleteEmployee/{id}")
public String deleteEmployee(@PathVariable(value = "id") int id) {
	this.service.deleteEmplyeeById(id);
	System.out.println("Delete Sucessfully");
    return "redirect:/";
}

@GetMapping("/viewEmployee/{id}")
public String viewEmployee(@PathVariable("id") int id, Model model) {
    // Retrieve employee details by ID from the service
    Emplyee employee = service.findById(id);
    
    // Add employee object to the model to pass it to the view
    model.addAttribute("employee", employee);
    
    // Return the view name to display employee details
    return "employeeDetails"; // Create a corresponding HTML template for displaying employee details
}


@PostMapping("/updateEmployeeImage/{id}")
public String updateEmployeeImage(@PathVariable("id") int id, @RequestParam("imageFile") MultipartFile imageFile) {
    // Handle image upload/update logic here
    service.updateEmployeeImage(id, imageFile);
    return "redirect:/viewEmployee/" + id;
}

@PostMapping("/deleteEmployeeImage/{id}")
public String deleteEmployeeImage(@PathVariable("id") int id) {
    // Handle image deletion logic here
    service.deleteEmployeeImage(id);
    return "redirect:/viewEmployee/" + id;
}
}
