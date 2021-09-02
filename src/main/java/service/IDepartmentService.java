package service;

import entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IDepartmentService  {
    public List<Department> getAllDepartments();
}
