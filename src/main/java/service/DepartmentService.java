package service;

import entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IDepartmentRepository;

import java.util.List;


@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private IDepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

}
