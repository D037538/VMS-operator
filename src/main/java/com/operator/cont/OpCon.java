package com.operator.cont;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

import net.sf.jasperreports.engine.JRException;


@Controller
public class OpCon {
	@Autowired
	private OperatorService operatorService;
	
	@Autowired
	private IVisitorService iVisitorService;
	
	@RequestMapping("/viewvisitorservice")  
    public ModelAndView viewstudents() throws JsonProcessingException{  
        Visitor[] list=operatorService.getAllVisitorList();
        return new ModelAndView("viewvisitorservice","list",list);  
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
		return "redirect:/viewvisitorservice";//will redirect to viewemp request mapping  
	}
	/* It opens the record for the given id in editvisitor page */
	@RequestMapping(value = "/editvisitor/{id}")
	public String edit(@PathVariable int id, ModelMap model) throws JsonProcessingException {
		Visitor visitor =  operatorService.getListByVisitorId(id);
		model.addAttribute("visitor", visitor);
		return "editvisitor";

	}
	
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("visitor") Visitor visitor) {
		long id=visitor.getId();
			operatorService.updateVisitorStatus(id);
		return new ModelAndView("redirect:/viewvisitorservice");
	}
	
	@RequestMapping(value = "/printticket/{id}")
	public String printTicket(@PathVariable int id, ModelMap model,HttpServletResponse response) throws IOException, SQLException, JRException {
		System.out.println("Pint id in controller"+id);
		int visitor = operatorService.ticketPrint(id,response);
		model.addAttribute("visitor", visitor);
		return "editvisitor";

	}
	/**
	 * It views list of states
	 * @return
	 */
	@ModelAttribute("states")
	public List<String> initializeStates() {

		List<String> countries = new ArrayList<String>();
		countries.add("Andhra Pradesh");
		countries.add("Arunachal Pradesh ");
		countries.add(" Bihar ");
		countries.add("Himachal Pradesh ");
		countries.add("Jharkhand ");
		countries.add("Maharashtra ");
		countries.add("Manipur ");
		return countries;
	}
/**
 * It views list of cities
 * @return
 */
	@ModelAttribute("cities")
	public List<String> initializeCities() {

		List<String> countries = new ArrayList<String>();
		countries.add("Mumbai");
		countries.add("Pune");
		countries.add(" Nagpur ");
		countries.add("Nashik ");
		countries.add("Palghar ");
		countries.add("Aurangabad ");
		countries.add("Solapur ");
		return countries;
	}
}
