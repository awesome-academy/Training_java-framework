package tpiv.mvcthymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tpiv.mvcthymeleaf.entities.Employee;
import tpiv.mvcthymeleaf.service.EmployeeServiceImpl;

@Controller
//@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeServiceImpl employeeService;

	@GetMapping("/")
	public String index(Model model) {
		List<Employee> employees = (List<Employee>) employeeService.loadEmployees();
		model.addAttribute("listEmployees", employees);
		return "employee/index";
	}

	@RequestMapping("/{id}")
	public ModelAndView show(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("edit");
		mav.addObject("employee", employeeService.loadEmployee(id));
		return mav;
	}

	@RequestMapping("/new")
	public String newEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);

		return "employee/new";
	}

	@RequestMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("employee/edit");
		Employee employee = employeeService.loadEmployee(id);
		mav.addObject("employee", employee);

		return mav;
	}

	@PostMapping("/")
	public String create(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		return "redirect:/";
	}

	@DeleteMapping("/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		employeeService.delete(id);
		return "redirect:/";
	}
}
