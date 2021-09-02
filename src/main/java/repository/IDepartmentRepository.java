package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import entity.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Short> {
}