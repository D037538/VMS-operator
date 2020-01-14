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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

import javassist.bytecode.ByteArray;
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

	@PostMapping("/registerVisitor")
	public Visitor registerVisitor(@RequestBody Visitor visitor) {
		return visitorRepository.save(visitor);
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
	@GetMapping("/visitorList")
	public Visitor[] printTicket() throws JsonProcessingException {
		Visitor[] visitorlist = operatorService.getAllVisitorList();
		return visitorlist;

	}

	/**
	 * method for get operator by id
		 */
	@GetMapping("/operators/{id}")
	public ResponseEntity<Operator> findme(@PathVariable Integer id) throws JsonProcessingException {
		Optional<Operator> operator = operatorService.getOperatorById(id);
		if (operator == null) {
			return new ResponseEntity<Operator>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Operator>(HttpStatus.OK);

	}
/*
 * method for get visitor by id
 */
	@GetMapping("/visitor/{id}")
	public Visitor findByVisitorId(@PathVariable Integer id) throws JsonProcessingException {
		System.out.println("id in controller is:" + id);
		return operatorService.getListByVisitorId(id);

	}


	/**
	 * method for delete visitor by id
	 * 
	 * @param id
	 * @return
	 */

	@DeleteMapping("/deleteVisitor/{id}")
	public String deleteVisitor(@PathVariable long id) { // return

		operatorService.deleteByIdVisitor(id);
		return "Visitor deleted successfully";
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
	public void getRpt1(HttpServletResponse response, @PathVariable int id, HttpServletResponse response1)
			throws JRException, IOException, SQLException {
		operatorService.ticketPrint(id, response1);

	}

	/**
	 * call visitor registerVisitor microservice
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
/**
 * methor for search visitor by id ,name,email
 * @param visitor
 * @return
 */
	@PostMapping("/search")
	public List<Visitor> searchVisitor(@RequestBody Visitor visitor) {
		return operatorService.searchVisitor(visitor);
	}
}
