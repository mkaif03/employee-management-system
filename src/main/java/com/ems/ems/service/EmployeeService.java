package com.ems.ems.service;
import com.ems.ems.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long id);
    EmployeeDTO saveEmployee(EmployeeDTO employee);
    EmployeeDTO updateEmployee(EmployeeDTO employee);
    void deleteEmployeeById(Long id);
}
