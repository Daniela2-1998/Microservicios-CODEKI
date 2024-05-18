package com.example.ticketCompra.controller;

import com.example.ticketCompra.model.CD;
import com.example.ticketCompra.model.TicketCompra;
import com.example.ticketCompra.service.CDClient;
import com.example.ticketCompra.service.TicketCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketComprasController {

    @Autowired
    private TicketCompraService ticketCompraService;

    @Autowired
    private CDClient cdClient;


    @GetMapping("/cds")
    public List<CD> findAllCDS(){
        return cdClient.findAllCDS();
    }

    @GetMapping("/cds/{id}")
    public Optional<CD> findCDById(@PathVariable Long id){
        return cdClient.buscarCDPorId(id);
    }


    @GetMapping("")
    public List<TicketCompra> getAllTickets(){
        return ticketCompraService.getAllTickets();
    }

    @PostMapping("/agregar")
    public TicketCompra addTicket(@RequestBody TicketCompra ticketCompra, @RequestParam("cd_id") Long id){
        return ticketCompraService.createTicket(ticketCompra, id);
    }

    @GetMapping("/{id}")
    public Optional<TicketCompra> findTicketById(@PathVariable Long id){
        return ticketCompraService.buscarTicketPorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteTicket(@PathVariable Long id){
        ticketCompraService.borrarTicketPorId(id);
    }

    @PutMapping("/actualizar")
    public Optional<TicketCompra> updateTicket(@RequestBody TicketCompra ticketCompra){
        return ticketCompraService.actualizarTicket(ticketCompra);
    }

}
