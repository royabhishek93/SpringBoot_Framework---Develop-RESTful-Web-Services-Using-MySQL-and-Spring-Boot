package com.abhishek.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.app.entities.Ticket;
import com.abhishek.app.service.TicketDAOImpl;

@RestController
@RequestMapping("/api")

public class TicketBookingController {

	@Autowired
	private TicketDAOImpl ticketDAOImpl;
	
	@PostMapping(value="/create")
	public void createTicket(@RequestBody Ticket ticket) {
		 ticketDAOImpl.createTicket(ticket);
	}
	
	@GetMapping(value="/ticket/{ticketId}")
	public Ticket getTicketById(@PathVariable("ticketId")  Integer ticketId) {
		return ticketDAOImpl.getTicketById(ticketId);
	}
	
	@GetMapping(value="/ticket/alltickets")
	public List<Ticket> getAllTickets() {
		return ticketDAOImpl.getAllBookedTickets();
	}
	
	
	@PutMapping(value="/updateTickets/{email}/{passengerName}")
	public void updateTicket(@PathVariable("email") String email,@PathVariable("passengerName") String passengerName) {
		 ticketDAOImpl.updateTicket(email, passengerName);
	}
	
	@DeleteMapping(value="/deleteTicket/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		 ticketDAOImpl.deleteTicket(ticketId);
	}
}
