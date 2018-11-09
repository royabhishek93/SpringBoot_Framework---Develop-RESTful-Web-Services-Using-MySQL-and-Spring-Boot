package com.abhishek.app.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.abhishek.app.entities.Ticket;



public class TicketRowMapper  implements RowMapper<Ticket>{

	@Override
	public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
	Ticket ticket= new Ticket();
	ticket.setBookingDate(rs.getDate("booking_date"));
	ticket.setDestStation(rs.getString("dest_station"));
	ticket.setEmail(rs.getString("email"));
	ticket.setPassengerName(rs.getString("passenger_name"));
	ticket.setSourceStation(rs.getString("source_station"));
	ticket.setTicketId(rs.getInt("ticket_id"));
		return ticket;
	}

}
