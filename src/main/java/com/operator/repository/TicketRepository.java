package com.operator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.operator.model.Ticket;

/**
 * 
 * @author Anushree
 *
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
