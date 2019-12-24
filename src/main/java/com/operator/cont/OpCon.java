package com.operator.cont;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.operator.model.Student;
import com.operator.model.Visitor;
import com.operator.model.VisitorDto;
import com.operator.service.IVisitorService;
import com.operator.service.OperatorService;


@Controller
public class OpCon {
	@Autowired
	private OperatorService operatorService;
	
	@Autowired
	private IVisitorService iVisitorService;
	@RequestMapping("/viewstudents")  
    public ModelAndView viewstudents() throws JsonProcessingException{  
        Visitor[] list=operatorService.getAllVisitorList();
        return new ModelAndView("viewstudents","list",list);  
    } 
	@RequestMapping(value ="/enroll",method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		Visitor student = new Visitor();
		model.addAttribute("student", student);
		return "enroll";
	}
	@ModelAttribute("countries")
	public List<String> initializeCountries() {

		List<String> countries = new ArrayList<String>();
		countries.add("INDIA");
		countries.add("USA");
		countries.add("CANADA");
		countries.add("FRANCE");
		countries.add("GERMANY");
		countries.add("ITALY");
		countries.add("OTHER");
		return countries;
	}
	
	@RequestMapping(value ="/save",method = RequestMethod.POST)
	public String saveRegistration(@Valid VisitorDto visitorDto,
			BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) {
		iVisitorService.addVisitor(visitorDto);
		//redirectAttributes.addFlashAttribute("message", "Student " + student.getFirstName()+" "+student.getLastName() + " saved");
		return "redirect:/viewstudents";//will redirect to viewemp request mapping  
	}
	
}
