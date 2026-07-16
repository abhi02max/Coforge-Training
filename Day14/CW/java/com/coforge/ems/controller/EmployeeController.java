package com.coforge.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@RequestMapping("home")
	public ModelAndView loadHome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHome");

		return mv;
	}

	@RequestMapping(value = "employee", method = RequestMethod.POST, params = "submit=Insert")
	public ModelAndView createEmployee(@ModelAttribute Employee employee) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHome");

		String result = "";
		boolean status = service.createEmployee(employee);

		if (status) {
			result = "SUCCESS : Employee Object Saved";
		} else {
			result = "FAILED : Employee Object Not Saved";
		}

		mv.addObject("result", result);

		return mv;
	}

	@RequestMapping(value = "employee", method = RequestMethod.POST, params = "submit=Update")
	public ModelAndView updateEmployee(@ModelAttribute Employee employee) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHome");

		String result = "";
		boolean status = service.updateEmployee(employee);

		if (status) {
			result = "SUCCESS : Employee Object Updated";
		} else {
			result = "FAILED : Employee Not Found, Nothing Updated";
		}

		mv.addObject("result", result);
		return mv;
	}

	@RequestMapping(value = "employee", method = RequestMethod.POST, params = "submit=Delete")
	public ModelAndView deleteEmployee(@RequestParam int eid) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHome");

		String result = "";

		boolean status = service.deleteEmployee(eid);

		if (status) {
			result = "SUCCESS : Employee Object Deleted";
		} else {
			result = "FAILED : Employee Not Found, Nothing Deleted";
		}

		mv.addObject("result", result);

		return mv;
	}

	@RequestMapping(value = "employee", method = RequestMethod.POST, params = "submit=Find")
	public ModelAndView findEmployee(@RequestParam int eid) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHome");

		String result = "";
		Employee found = service.findEmployee(eid);

		if (found != null) {
			result = "SUCCESS : " + found.toString();
		} else {
			result = "FAILED : Employee Not Found";
		}

		mv.addObject("result", result);
		return mv;
	}

	@RequestMapping(value = "employee", method = RequestMethod.POST, params = "submit=FindAll")
	public ModelAndView findAllEmployees() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHome");

		List<Employee> list = service.findAllEmployees();

		mv.addObject("result", "SUCCESS : " + list.size() + " Employee(s) Found");
		mv.addObject("employeeList", list);
		return mv;
	}

}
