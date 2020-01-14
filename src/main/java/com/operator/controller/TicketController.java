package com.operator.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.operator.model.Ticket;
import com.operator.model.Visitor;
import com.operator.service.OperatorService;
import com.operator.service.TicketService;

/**
 * 
 * @author Anushree
 *
 */
@RestController
@RequestMapping("/api")
public class TicketController {
	@Autowired
	private TicketService ticketService;
	@Autowired
	private OperatorService operatorService;

	public TicketService getTicketService() {
		return ticketService;
	}

	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	public OperatorService getOperatorService() {
		return operatorService;
	}

	public void setOperatorService(OperatorService operatorService) {
		this.operatorService = operatorService;
	}

	@PostMapping("/registerTicket")
	public Ticket registerTicket(@RequestBody Ticket ticket, Visitor visitor) {
		return ticketService.registerTicket(ticket);
	}

	/**
	 * method for get all categories
	 * 
	 * @return expenseCategory
	 * @throws JsonProcessingException
	 * @throws ResourceNotFoundException
	 * @throws ExpenseCategoryServiceException
	 */

	@GetMapping("/tickets")
	public List<Ticket> getAllTicket() throws JsonProcessingException {
		List<Ticket> ticket = ticketService.getAllTicket();
		return ticket;

	}

	@PostMapping("/visitorticket/{id}")
	public Ticket findByVisitorIdTicket(@PathVariable Long id) throws JsonProcessingException {
		System.out.println("id in controller is:" + id);
		Visitor visitor = operatorService.getListByVisitorId(id);
		Ticket ticket = new Ticket();
		ticket.setVisitor(visitor);
		ticket.setTicketName("Anushree");
		return ticketService.registerTicket(ticket);
	}

}
