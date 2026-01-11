package com.ems.ems.controller.ui;

import com.ems.ems.dto.EmployeeDTO;
import com.ems.ems.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees-ui")
public class EmployeeViewController {

    private final EmployeeService employeeService;

    public EmployeeViewController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // LIST
    @GetMapping
    public String showEmployeesPage(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }

    // SHOW ADD FORM
    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new EmployeeDTO());
        return "add-employee";
    }

    // ADD
    @PostMapping("/add")
    public String addEmployee(
            @Valid @ModelAttribute("employee") EmployeeDTO employee,
            BindingResult result) {

        if (result.hasErrors()) {
            return "add-employee";
        }

        employeeService.saveEmployee(employee);
        return "redirect:/employees-ui?success=Employee added successfully";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees-ui?success=Employee deleted successfully";
    }

    // SHOW EDIT FORM
    @GetMapping("/edit/{id}")
    public String showEditEmployeeForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "edit-employees";
    }

    // UPDATE
    @PostMapping("/update/{id}")
    public String updateEmployee(
            @PathVariable Long id,
            @Valid @ModelAttribute("employee") EmployeeDTO employee,
            BindingResult result) {

        if (result.hasErrors()) {
            return "edit-employee";
        }

        employee.setId(id);
        employeeService.updateEmployee(employee);
        return "redirect:/employees-ui?success=Employee updated successfully";
    }

    // TEST
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Controller is working";
    }
}
