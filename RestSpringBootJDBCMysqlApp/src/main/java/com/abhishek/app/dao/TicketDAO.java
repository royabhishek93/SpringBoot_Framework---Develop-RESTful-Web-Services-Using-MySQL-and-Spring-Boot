package com.abhishek.app.dao;

import java.util.Date;
import java.util.List;

import com.abhishek.app.entities.Ticket;

public interface TicketDAO {
	public abstract void  createTicket(Ticket ticket);
	public abstract Ticket  getTicketById(Integer ticketId);
	public abstract  List<Ticket>  getAllBookedTickets();
	public abstract void  updateTicket(String email, String passengerName );
	public abstract void  deleteTicket(Integer ticketId );

}
