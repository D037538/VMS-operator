package com.operator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operator.dto.TicketDto;
import com.operator.model.Ticket;
import com.operator.repository.TicketRepository;

@Service
public class TicketService {
	@Autowired 
	private TicketRepository ticketRepository;
	public Ticket registerTicket(TicketDto ticketDto) {
		Ticket ticket = new Ticket();
		//ticket.setTicketName(ticketDto.getTicketName());
		ticketRepository.save(ticket);
		return ticket;
	}

	public List<Ticket> getAllTicket() {
		return ticketRepository.findAll();
	}

}
