package com.example.ticketCompra.repository;

import com.example.ticketCompra.model.TicketCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketCompraRepository extends JpaRepository<TicketCompra, Long> {

}
