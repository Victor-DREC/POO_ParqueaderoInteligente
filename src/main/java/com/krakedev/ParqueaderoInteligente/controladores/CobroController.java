package com.krakedev.ParqueaderoInteligente.controladores;

import com.krakedev.ParqueaderoInteligente.modelo.TicketCobro;
import com.krakedev.ParqueaderoInteligente.servicios.ServicioCobro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/cobros")
public class CobroController {

    private final ServicioCobro servicioCobro;

    public CobroController(ServicioCobro servicioCobro) {
        this.servicioCobro = servicioCobro;
    }

    @PostMapping("/procesar/{placa}/{horas}")
    public ResponseEntity<?> procesarSalida(@PathVariable String placa, @PathVariable int horas) {
        TicketCobro ticket = servicioCobro.procesarSalida(placa, horas);
        if (ticket != null) {
            return ResponseEntity.ok(ticket);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No existe un vehículo estacionado con la placa: " + placa);
    }

    @GetMapping("/total")
    public ResponseEntity<Double> totalRecaudado() {
        return ResponseEntity.ok(servicioCobro.calcularTotalRecaudado());
    }

    @GetMapping("/historial")
    public ResponseEntity<ArrayList<TicketCobro>> historial() {
        return ResponseEntity.ok(servicioCobro.listarTickets());
    }
}