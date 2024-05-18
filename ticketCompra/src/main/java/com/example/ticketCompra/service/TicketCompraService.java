package com.example.ticketCompra.service;

import com.example.ticketCompra.model.CD;
import com.example.ticketCompra.model.TicketCompra;
import com.example.ticketCompra.repository.TicketCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketCompraService {

    @Autowired
    CDClient cdClient;

    @Autowired
    TicketCompraRepository ticketCompraRepository;


    public List<TicketCompra> getAllTickets(){
        List<TicketCompra> tickets = ticketCompraRepository.findAll();
        return tickets;
    }

    public TicketCompra createTicket(TicketCompra ticketCompra, Long cdId){
        CD cd = cdClient.buscarCDPorId(cdId)
                .orElseThrow(() -> new IllegalArgumentException("No fue posible encontrar el CD: " + cdId));

        ticketCompra.setCd(cd);
        return ticketCompraRepository.save(ticketCompra);
    }

    public Optional<TicketCompra> buscarTicketPorId(Long id){
        return ticketCompraRepository.findById(id);
    }


    public Optional<TicketCompra> actualizarTicket(TicketCompra ticketCompra){
        ticketCompraRepository.save(ticketCompra);
        return ticketCompraRepository.findById(ticketCompra.getId());
    }

    public void borrarTicketPorId(Long id){
        ticketCompraRepository.deleteById(id);
    }
}
