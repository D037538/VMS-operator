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
	public Ticket registerTicket(Ticket ticket) {
		/*
		 * Ticket ticket = new Ticket();
		 * ticket.setTicketName(ticketDto.getTicketName());
		 *///	ticket.setVisitor(visitor);
		//t1.setVisitor(new Visitor(visitorDto.getName()))
		
		
		ticketRepository.save(ticket);
		return ticket;
	}

	public List<Ticket> getAllTicket() {
		return ticketRepository.findAll();
	}

}
