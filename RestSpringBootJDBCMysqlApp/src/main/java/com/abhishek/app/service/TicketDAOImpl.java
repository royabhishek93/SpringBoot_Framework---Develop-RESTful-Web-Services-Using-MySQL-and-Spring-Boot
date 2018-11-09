package com.abhishek.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.abhishek.app.dao.TicketDAO;

import com.abhishek.app.entities.Ticket;

@Repository
public class TicketDAOImpl implements TicketDAO{

	@Autowired
	private JdbcTemplate  jdbcTemplate;
	
	@Override
	public void createTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		String CREATE_TICKET_SQL="INSERT INTO ticket(booking_date,dest_station,email,passenger_name,source_station) VALUES(?,?,?,?,?)";
		System.out.println("--"+ticket.getBookingDate()+"**"+ticket.getDestStation()+"***"+
				ticket.getEmail()+"---"+ticket.getPassengerName()+"----"+ticket.getSourceStation());
		
		int update=jdbcTemplate.update(CREATE_TICKET_SQL, ticket.getBookingDate(),ticket.getDestStation(),
				ticket.getEmail(),ticket.getPassengerName(),ticket.getSourceStation());
		if(update==1) {
			System.out.println("Employee created sucessfully ");
			
		}
		
		
	}

	@Override
	public Ticket getTicketById(Integer ticketId) {
		String GET_TICKET_SQL="Select * from ticket where ticket_id=?";
		Ticket ticket =jdbcTemplate.queryForObject(GET_TICKET_SQL, new TicketRowMapper(),ticketId);
		return ticket;
	}

	@Override
	public List<Ticket> getAllBookedTickets() {
		String GET_All_TICKETS_SQL="Select * from ticket ";
		List<Ticket> ticket =jdbcTemplate.query(GET_All_TICKETS_SQL,new TicketRowMapper());
		return ticket;
		
	}

	@Override
	public void updateTicket(String email, String passengerName) {
		String UPDATE_TICKET="Update ticket set passenger_name=?  where email=? ";
		int update=jdbcTemplate.update(UPDATE_TICKET,passengerName,email);
		if(update==1) {
			System.out.println("Employee updated sucessfully ");
		}
		
	}

	@Override
	public void deleteTicket(Integer ticketId) {
		String DELETE_TICKET="Delete from ticket   where ticket_id=?";
		int  update =jdbcTemplate.update(DELETE_TICKET,  ticketId);
		if(update==1) {
			System.out.println("Employee is Deleted......");			
		}
		
	}

}
