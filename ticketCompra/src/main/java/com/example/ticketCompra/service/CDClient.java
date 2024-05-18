package com.example.ticketCompra.service;

import com.example.ticketCompra.model.CD;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "APICDS", url = "http://localhost:5050/cds", configuration = CD.class, dismiss404 = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public interface CDClient {



    @GetMapping("")
    List<CD> findAllCDS();

    @GetMapping("/{id}")
    Optional<CD> buscarCDPorId(@PathVariable Long id);
}
