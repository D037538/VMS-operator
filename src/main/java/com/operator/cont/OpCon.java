package com.operator.cont;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.operator.exceptionhandling.ResourceNotFoundException;
import com.operator.model.Visitor;
import com.operator.model.VisitorDto;
import com.operator.service.IVisitorService;
import com.operator.service.OperatorService;
import com.operator.service.VisitorServiceException;

import net.sf.jasperreports.engine.JRException;

//@RestController
@Controller
public class OpCon {
	// private final Logger logger = LoggerFactory.getLogger(this.getClass());
	// private final Logger logger = LogManager.getLogger(OpCon.class);
	private static final Logger logger = LogManager.getLogger(OpCon.class);
	@Autowired
	private OperatorService operatorService;

	@Autowired
	private IVisitorService iVisitorService;
	/**
	 * It views list of visitors
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("/viewvisitorservice")
	public ModelAndView viewstudents() throws JsonProcessingException {

		Visitor[] list = operatorService.getAllVisitorList();
		return new ModelAndView("viewvisitorservice", "list", list);
	}

	/**
	 * It views list of countries
	 * 
	 * @return
	 */
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

	/* It opens the record for the given id in editvisitor page */
	@RequestMapping(value = "/editvisitor/{id}")
	public String edit(@PathVariable int id, ModelMap model) throws JsonProcessingException {
		Visitor visitor = operatorService.getListByVisitorId(id);
		model.addAttribute("visitor", visitor);
		return "editvisitor";

	}

	/*
	 * It updates record for the given id in editvisitor page and redirects to
	 * /viewvisitorservice
	 */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("visitor") Visitor visitor, HttpServletResponse response)
			throws IOException, SQLException, JRException {
		long id = visitor.getId();
		String toemail = visitor.getContactPersonEmail();
		System.out.println("Pint id in controller" + toemail);
		operatorService.updateVisitorStatus(id, visitor);
		// operatorService.ticketPrint(id,response);
		return new ModelAndView("redirect:/viewvisitorservice");
	}

	@RequestMapping(value = "/sendemail", method = RequestMethod.POST)
	public ModelAndView emailSend(@ModelAttribute("visitor") Visitor visitor, HttpServletResponse response)
			throws IOException, SQLException, JRException {
		String toemail = visitor.getContactPersonEmail();
		String subject = visitor.getReasonForVisit();
		System.out.println("Pint id in controller" + toemail);
		return new ModelAndView("redirect:/viewvisitorservice");
	}

	/**
	 * It generate ticket print
	 * 
	 * @param id
	 * @param model
	 * @param response
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 * @throws JRException
	 */
	@RequestMapping(value = "/printticket/{id}")
	public String printTicket(@PathVariable int id, ModelMap model, HttpServletResponse response,
			@ModelAttribute("visitor") Visitor visitor) throws IOException, SQLException, JRException {
		String toemail = visitor.getContactPersonEmail();
		//String status=
		System.out.println("Pint id in controller" + toemail);
		int visitor1 = operatorService.ticketPrint(id, response);
		operatorService.sendMailToContactPrson();
		/*
		 * String bodyMsg= "Hello"+" "+visitor.getContactPersonName()+","+
		 * 
		 * "\n" + " Following visitor want to meet you regarding  :"+ "\n"+"Name : Rama"
		 * + "\n"+"Purpose : Meeting"+ "\n"+" "+"\n"+"\n"+" "+"\n"+
		 * "Thanks and regards,"+"\n";
		 * smtpMailSender.send(visitor.getContactPersonEmail(),bodyMsg,visitor.
		 * getReasonForVisit());
		 */
		model.addAttribute("visitor", visitor1);
		return "editvisitor";

	}

	/**
	 * It views list of states
	 * 
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
	 * 
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

	// Happy path, an visitor is returned as response
	@RequestMapping(value = "/visitor", method = RequestMethod.GET)
	public Visitor[] getVisitor1() throws ResourceNotFoundException, VisitorServiceException, JsonProcessingException {
		Visitor[] visitor = operatorService.getAllVisitorList();

		if (visitor == null) {
			throw new ResourceNotFoundException("Visitor not found");
		}
		return visitor;
	}

	// no visitor found so ResourceNotFoundException is thrown
	@RequestMapping(value = "/visitor2", method = RequestMethod.GET)
	public Visitor getVisitor2() throws ResourceNotFoundException, VisitorServiceException {
		try {
			Visitor visitor = operatorService.getVisitorNull();
			if (visitor == null) {
				throw new ResourceNotFoundException("Visitor not found");
			}

			return visitor;
		} catch (VisitorServiceException e) {
			throw new VisitorServiceException("Internal Server Exception while getting exception");
		}
	}

	// Some exception is thrown by service layer
	@RequestMapping(value = "/visitor3", method = RequestMethod.GET)
	public Visitor getVisitor() throws ResourceNotFoundException, VisitorServiceException {
		try {
			Visitor visitor = operatorService.getVisitorException();
			if (visitor == null) {
				throw new ResourceNotFoundException("Visitor not found");
			}
			return visitor;
		} catch (VisitorServiceException e) {
			throw new VisitorServiceException("Internal Server Exception while getting exception");
		}
	}
}
