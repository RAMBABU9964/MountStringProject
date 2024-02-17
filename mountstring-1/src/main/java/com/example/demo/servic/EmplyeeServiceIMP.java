package com.example.demo.servic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Emplyee;
import com.example.demo.repo.EmplyeeRepo;

import jakarta.persistence.criteria.Path;

@Service
public class EmplyeeServiceIMP implements EmplyeeService {
	@Autowired
	EmplyeeRepo repo;
	
	
	private static final String UPLOAD_DIR = "uploads/";

	@Override
	public boolean emailExists(String email) {
		if(repo.findByEmail(email)==null) {
			return false;
			}else {
				return true;
			}
	}

	@Override
	public String addUser(Emplyee emplyee) {
		repo.save(emplyee);
		return "User added successfully";
		
	}

	@Override
	public List<Emplyee> fetchAllData() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Emplyee getEmployeeById(int id) {
		Optional<Emplyee> optional=repo.findById(id);
		Emplyee employee=null;
		if(optional.isPresent()) {
			employee=optional.get();
		}else {
			throw new RuntimeException("Emplyee not found for id::"+id);
		}
		return employee;
	}

	
	
	@Override
	public void deleteEmplyeeById(int id) {
     this.repo.deleteById(id);		
	}
	
	
	@Override
    public List<Emplyee> fetchBySalaryRange(int minSalary, int maxSalary) {
        return repo.findBySalaryBetween(minSalary, maxSalary);
    }

	@Override
	public List<Emplyee> fetchByRole(String role) {
		
		return repo.findByRole(role);
	}

	@Override
	public Emplyee findById(int id) {
		
		return repo.findOneById(id);
	}

	@Override
	public void deleteEmployeeImage(int id) {
		Emplyee employee = repo.findOneById(id);
        if (employee == null) {
            // Handle error: Employee not found
            return;
        }

        // Delete the image file from the file system
        String imagePath = employee.getImage();
        if (imagePath != null) {
            try {
                Files.deleteIfExists(Paths.get(imagePath));
                // Update the employee's image path to null
                employee.setImage(null);
                repo.save(employee);
            } catch (IOException e) {
                // Handle error: File deletion failed
                e.printStackTrace();
            }
        }
    }
	

	@Override
    public void updateEmployeeImage(int id, MultipartFile imageFile) {
        Emplyee employee = repo.findOneById(id);
        if (employee == null) {
            // Handle error: Employee not found
            return;
        }

        //
    }
	    
		
	

	

		
}
