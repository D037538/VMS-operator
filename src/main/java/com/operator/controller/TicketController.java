package com.operator.controller;

import java.util.Collection;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.operator.dto.TicketDto;
import com.operator.model.ExpenseCategory;
import com.operator.model.Ticket;
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

	@PostMapping("/registerTicket")
	public Ticket registerTicket(@RequestBody TicketDto ticketDto) {
		// System.out.println("Expense name" + expenseCategoryDto.getCategoryName());
		return ticketService.registerTicket(ticketDto);
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
	public Collection<Ticket> getAllTicket() throws JsonProcessingException {
		List<Ticket> ticket = ticketService.getAllTicket();
		return ticket;
		
	}

}
