package by.nata.controllers;

import by.nata.dto.CompanyAddressDto;
import by.nata.dto.CompanyDto;
import by.nata.dto.ContactEmployeeDto;
import by.nata.dto.EmployeeDto;
import by.nata.service.CompanyService;
import by.nata.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final CompanyService companyService;

@Autowired
    public EmployeeController(EmployeeService employeeService, CompanyService companyService) {
        this.employeeService = employeeService;
    this.companyService = companyService;
}
    @GetMapping
    public String findAll(Model model){
    model.addAttribute("employees", employeeService.findAllEmployee());
    return "employees";
    }
    @GetMapping("/{id}")
    public String findById(@PathVariable("id") String id, Model model){
    model.addAttribute("employee", employeeService.findEmployeeById(id));
    return "employee";
    }
    @GetMapping("/employees")
    public String goToPath(){

        return "employees";
    }
    @PostMapping("/employees")
    public String createEmployee(@ModelAttribute  EmployeeDto employeeDto,
                                 @ModelAttribute CompanyDto companyDto,
                                 BindingResult bindingResult,
                                 Model model ){
        if (bindingResult.hasErrors()) {

            model.addAttribute("errors", bindingResult.getAllErrors());
            return "employees";
        }
    employeeService.saveEmployee(employeeDto, companyDto);

    return "redirect:/index";
    }
}
