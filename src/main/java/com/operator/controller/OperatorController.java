package com.operator.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.operator.model.Operator;
import com.operator.model.Ticket;
import com.operator.model.Visitor;
import com.operator.repository.VisitorRepository;
import com.operator.service.OperatorService;
import com.operator.service.TicketService;

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
	@Autowired
	private TicketService ticketService;
	private static final Logger logger = LogManager.getLogger(OperatorController.class);

	/**
	 * 
	 * @param operatorDto
	 * @return object of register object
	 */
	@PostMapping("/registerOperator")
	public Operator registerOperator(@Valid @RequestBody Operator operator) {
		return operatorService.registerOperator(operator);
	}

	/*
	 * 
	 * /**
	 * 
	 * @return list of all operators
	 */
	@GetMapping("/operators")
	public List<Operator> getAllOperator() {

		logger.debug("Debug message");
		logger.info("Info message");
		logger.warn("Warn message");
		logger.error("Error message");
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
		Optional<Operator> operator = operatorService.getOperatorById(id);
		if (operator == null) {
			return new ResponseEntity<Operator>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Operator>(HttpStatus.OK);

	}

	@GetMapping("/visitor/{id}")
	public Visitor findByVisitorId(@PathVariable Integer id) throws JsonProcessingException {
		System.out.println("id in controller is:" + id);
		return operatorService.getListByVisitorId(id);

	}

	/*
	 * @PostMapping("/visitorticket/{id}") public Ticket
	 * findByVisitorIdTicket(@PathVariable Long id) throws JsonProcessingException {
	 * System.out.println("id in controller is:" + id); // Visitor visitor =
	 * operatorService.getListByVisitorId(id);
	 * 
	 * Visitor visitor = new Visitor(2, "Anushree", "anu@gmail.com", 0,
	 * "9845671230", "Deola", "India", "Maharastra", "Pune", "adhar card", "Ekta",
	 * "ekta@gmail.com", "naukari", "interview", 0);
	 * 
	 * Ticket ticket = new Ticket(); ticket.setTicketName("sdf");
	 * 
	 * //visitorRepository.save(visitor);
	 * 
	 * 
	 * List<Visitor> visitor = visitorRepository.findAll();
	 * 
	 * ticket.setVisitor(visitor); System.out.println("id in ticket is:" + ticket);
	 * ticketService.registerTicket(ticket);
	 * 
	 * 
	 * return ticket;
	 * 
	 * }
	 */

	/**
	 * method for update visitor status by id
	 * 
	 * @param id
	 * @return
	 */
	/*
	 * @PutMapping("/updateVisitor/{id}") public String
	 * UpdateVisitorStatus(@PathVariable long id) { //return
	 * operatorService.updateVisitorStatus(id); }
	 */

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

	}

	/**
	 * 
	 * @param visitor
	 * @return
	 */
	@PostMapping("/registervisitor")
	public String createProducts(@RequestBody Visitor visitor) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Visitor> entity = new HttpEntity<Visitor>(visitor, headers);

		return restTemplate.exchange("http://localhost:8084/visitor/addVisitor", HttpMethod.POST, entity, String.class)
				.getBody();
	}
}
