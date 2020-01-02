package com.operator.controller;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.operator.dto.OperatorDto;
import com.operator.model.Operator;
import com.operator.model.Visitor;
import com.operator.repository.VisitorRepository;
import com.operator.service.OperatorService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/api")
/**
 * 
 * @author Anushree
 *
 */
public class OperatorController {
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private VisitorRepository visitorRepository;
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 
	 * @param operatorDto
	 * @return object of register object
	 */
	@PostMapping("/registerOperator")
	public Operator registerOperator(@RequestBody Operator operator) {
		return operatorService.registerOperator(operator);
	}
/*
 
	/**
	 * 
	 * @return list of all operators
	 */
	@GetMapping("/operators")
	public List<Operator> getAllOperator() {
		List<Operator> operator = operatorService.getAllOperator();
		return operator;
	}
	
	/**
	 * method for call visitor microservice get all visitor list
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	@GetMapping(value = "/visitorList", consumes = "application/json;charset=UTF-8")
	public Visitor[] printTicket() throws JsonProcessingException {
		Visitor[] visitorlist = operatorService.getAllVisitorList();
		return visitorlist;

	}

	/**
	 * method for get visitor by id
	 * 
	 * @param id
	 * @return record by visitor id
	 * @throws JsonProcessingException
	 */
	@GetMapping("/operators/{id}")
	public ResponseEntity<Operator> findme(@PathVariable Integer id) throws JsonProcessingException {
		Optional<Operator> operator=operatorService.getOperatorById(id);
		if(operator==null) {
			return new ResponseEntity<Operator> (HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Operator> (HttpStatus.OK);

	}
	@GetMapping("/visitor/{id}")
	public Visitor findByVisitorId(@PathVariable Integer id) throws JsonProcessingException {
		System.out.println("id in controller is:" + id);
		return operatorService.getListByVisitorId(id);

	}
	/**
	 * method for update visitor status by id
	 * 
	 * @param id
	 * @return
	 */
	@PutMapping("/updateVisitor/{id}")
	public String UpdateVisitorStatus(@PathVariable long id) {
		return operatorService.updateVisitorStatus(id);
	}

	/**
	 * methods for print token print
	 * 
	 * @param response1
	 * @param visitor_id
	 * @throws JRException
	 * @throws IOException
	 * @throws SQLException
	 */
	@GetMapping("/printToken/{id}")
	public void getRpt1(HttpServletResponse response, @PathVariable int visitor_id, HttpServletResponse response1)
			throws JRException, IOException, SQLException {

		System.out.println("visitor_id" + visitor_id);
		operatorService.ticketPrint(visitor_id, response1);
		operatorService.sendMailToContactPerson();
	}
	/**
	 * 
	 * @param visitor
	 * @return
	 */
	@PostMapping("/registervisitor")
	   public String createProducts(@RequestBody Visitor visitor) {
	      HttpHeaders headers = new HttpHeaders();
	       HttpEntity<Visitor> entity = new HttpEntity<Visitor>(visitor,headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8084/visitor/addVisitor", HttpMethod.POST, entity, String.class).getBody();
	   }
}
